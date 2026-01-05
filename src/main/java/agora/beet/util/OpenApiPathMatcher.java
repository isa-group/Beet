package agora.beet.util;

import agora.beet.model.harFiles.PathMatch;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Juan C. Alonso
 * This class is used to obtain the corresponding PathItem from an OAS given a path from a .har file that may contain
 * path parameters.
 */
public final class OpenApiPathMatcher {

    private OpenApiPathMatcher() {
    }

    /**
     * Matches a concrete request path against an OpenAPI specification.
     *
     * @param concretePath request path (e.g., "/users/42/orders/7")
     * @param openAPI      parsed OpenAPI specification
     * @return PathMatch or null if no path matches
     */
    public static PathMatch match(
            String concretePath,
            OpenAPI openAPI
    ) {
        if (openAPI == null || openAPI.getPaths() == null) {
            return null;
        }

        String normalizedPath = normalize(concretePath);
        Paths paths = openAPI.getPaths();

        PathItem bestItem = null;
        String bestSpecPath = null;
        Map<String, String> bestParams = null;
        int bestScore = Integer.MIN_VALUE;

        for (Map.Entry<String, PathItem> entry : paths.entrySet()) {
            String specPath = normalize(entry.getKey());

            if (!sameStructure(normalizedPath, specPath)) {
                continue;
            }

            Pattern pattern = compilePattern(specPath);
            Matcher matcher = pattern.matcher(normalizedPath);

            if (!matcher.matches()) {
                continue;
            }

            int score = computeSpecificityScore(specPath);

            if (score > bestScore ||
                    (score == bestScore &&
                            bestSpecPath != null &&
                            specPath.compareTo(bestSpecPath) < 0)) {

                bestScore = score;
                bestSpecPath = specPath;
                bestItem = entry.getValue();
                bestParams = extractPathParams(specPath, matcher);
            }
        }

        return bestItem == null ? null : new PathMatch(bestItem, bestParams, bestSpecPath);
    }

    /* ==============================
     * Core logic
     * ============================== */

    private static String normalize(String path) {
        if (path == null || path.isEmpty()) {
            return "/";
        }
        String p = path.startsWith("/") ? path : "/" + path;
        return (p.endsWith("/") && p.length() > 1)
                ? p.substring(0, p.length() - 1)
                : p;
    }

    private static boolean sameStructure(String path, String template) {
        return segmentCount(path) == segmentCount(template);
    }

    private static int segmentCount(String path) {
        return path.equals("/") ? 0 : path.split("/").length - 1;
    }

    private static Pattern compilePattern(String template) {
        String regex = template.replaceAll("\\{[^/]+}", "([^/]+)");
        return Pattern.compile("^" + regex + "$");
    }

    /**
     * Specificity heuristic:
     *  - static segments are heavily favored
     *  - fewer parameters win
     */
    private static int computeSpecificityScore(String template) {
        int staticSegments = 0;
        int paramSegments = 0;

        for (String segment : template.split("/")) {
            if (segment.isEmpty()) continue;

            if (segment.startsWith("{") && segment.endsWith("}")) {
                paramSegments++;
            } else {
                staticSegments++;
            }
        }

        return (staticSegments * 10) - paramSegments;
    }

    private static Map<String, String> extractPathParams(
            String template,
            Matcher matcher
    ) {
        Map<String, String> params = new LinkedHashMap<>();

        Matcher nameMatcher = Pattern
                .compile("\\{([^/}]+)}")
                .matcher(template);

        int index = 1;
        while (nameMatcher.find()) {
            params.put(nameMatcher.group(1), matcher.group(index++));
        }

        return params;
    }
}

