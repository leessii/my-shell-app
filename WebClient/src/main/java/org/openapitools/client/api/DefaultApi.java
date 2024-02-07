package org.openapitools.client.api;

import org.openapitools.client.ApiClient;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.openapitools.client.model.ActivityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-05T19:03:44.797206696+01:00[Europe/Vienna]")
public class DefaultApi {
    private ApiClient apiClient;

    public DefaultApi() {
        this(new ApiClient());
    }

    @Autowired
    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get events by type
     * 
     * <p><b>200</b> - Successful response
     * <p><b>404</b> - No activity found
     * @param type The type of event to filter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec activityGetRequestCreation(String type) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/activity", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get events by type
     * 
     * <p><b>200</b> - Successful response
     * <p><b>404</b> - No activity found
     * @param type The type of event to filter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ActivityResponse> activityGet(String type) throws WebClientResponseException {
        ParameterizedTypeReference<ActivityResponse> localVarReturnType = new ParameterizedTypeReference<ActivityResponse>() {};
        return activityGetRequestCreation(type).bodyToMono(localVarReturnType);
    }

    /**
     * Get events by type
     * 
     * <p><b>200</b> - Successful response
     * <p><b>404</b> - No activity found
     * @param type The type of event to filter
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<Void>> activityGetWithHttpInfo(String type) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return activityGetRequestCreation(type).toEntity(localVarReturnType);
    }

    /**
     * Get events by type
     * 
     * <p><b>200</b> - Successful response
     * <p><b>404</b> - No activity found
     * @param type The type of event to filter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec activityGetWithResponseSpec(String type) throws WebClientResponseException {
        return activityGetRequestCreation(type);
    }
}
