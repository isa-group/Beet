package agora.beet.model.harFiles;
import io.swagger.v3.oas.models.PathItem;

import java.util.Map;

/**
 *
 * @author Juan C. Alonso
 */
public record PathMatch(PathItem pathItem, Map<String, String> pathParams, String path) {}

