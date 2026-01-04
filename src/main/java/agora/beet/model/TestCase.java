package agora.beet.model;

import agora.beet.model.harFiles.HttpEntry;
import agora.beet.model.harFiles.Parameter;
import agora.beet.model.harFiles.PostData;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Juan C. Alonso
 */
public class TestCase {

    private String testCaseId;
    private String operationId;
    private String path;
    private String httpMethod;
    private Map<String, String> headerParameters;
    private Map<String, String> pathParameters;
    private Map<String, String> queryParameters;
    private Map<String, String> formParameters;
    private String bodyParameter;
    private String statusCode;
    private String responseBody;

    public TestCase(String testCaseId, String operationId, String path, String httpMethod,
                    Map<String, String> headerParameters, Map<String, String> pathParameters,
                    Map<String, String> queryParameters, Map<String, String> formParameters,
                    String bodyParameter, String statusCode, String responseBody) {
        this.testCaseId = testCaseId;
        this.operationId = operationId;
        this.path = path;
        this.httpMethod = httpMethod;
        this.headerParameters = headerParameters;
        this.pathParameters = pathParameters;
        this.queryParameters = queryParameters;
        this.formParameters = formParameters;
        this.bodyParameter = bodyParameter;
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public TestCase(HttpEntry httpEntry) {
        this.testCaseId = UUID.randomUUID().toString();

        URI uri = URI.create(httpEntry.getRequest().getUrl());
        this.operationId = ""; // TODO
        this.path = uri.getPath();
        this.httpMethod = httpEntry.getRequest().getMethod();

        // Header parameters
        this.headerParameters = new HashMap<>();
        List<Parameter> headerParametersList = httpEntry.getRequest().getHeaders();
        if (headerParametersList != null) {
            for (Parameter headerParameter: headerParametersList) {
                headerParameters.put(headerParameter.getName(), headerParameter.getValue());
            }
        }

        this.pathParameters = new HashMap<>();  // TODO: Implement

        this.queryParameters = new HashMap<>();
        List<Parameter> queryParameterList = httpEntry.getRequest().getQueryString();
        if (queryParameterList != null) {
            for (Parameter queryParameter: queryParameterList) {
                queryParameters.put(queryParameter.getName(), queryParameter.getValue());
            }

        }

        PostData postData = httpEntry.getRequest().getPostData();
        if (postData != null) {
            this.bodyParameter = postData.getText();

            this.formParameters = new HashMap<>();
            List<Parameter> formParametersList = postData.getParams();
            if (formParametersList != null) {
                for (Parameter formParameter: formParametersList) {
                    formParameters.put(formParameter.getName(), formParameter.getValue());
                }
            }

        }

        this.statusCode = httpEntry.getResponse().getStatus().toString();
        this.responseBody = httpEntry.getResponse().getContent().getText();

    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(String testCaseId) {
        this.testCaseId = testCaseId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Map<String, String> getHeaderParameters() {
        return headerParameters;
    }

    public void setHeaderParameters(Map<String, String> headerParameters) {
        this.headerParameters = headerParameters;
    }

    public Map<String, String> getPathParameters() {
        return pathParameters;
    }

    public void setPathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
    }

    public Map<String, String> getQueryParameters() {
        return queryParameters;
    }

    public void setQueryParameters(Map<String, String> queryParameters) {
        this.queryParameters = queryParameters;
    }

    public Map<String, String> getFormParameters() {
        return formParameters;
    }

    public void setFormParameters(Map<String, String> formParameters) {
        this.formParameters = formParameters;
    }

    public String getBodyParameter() {
        return bodyParameter;
    }

    public void setBodyParameter(String bodyParameter) {
        this.bodyParameter = bodyParameter;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String toString() {
        return "TestCase{" +
                "testCaseId='" + testCaseId + '\'' +
                ", operationId='" + operationId + '\'' +
                ", path='" + path + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", headerParameters=" + headerParameters +
                ", pathParameters=" + pathParameters +
                ", queryParameters=" + queryParameters +
                ", formParameters=" + formParameters +
                ", bodyParameter='" + bodyParameter + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", responseBody='" + responseBody + '\'' +
                '}';
    }
    
}
