/*
 * Random Event API
 * A simple API for random events and events by type.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.junit.Test;
import org.junit.Ignore;
import org.openapitools.client.model.ActivityResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * API tests for DefaultApi
 */

public class DefaultApiTest {

    private final DefaultApi api = new DefaultApi();

    
    /**
     * Get events by type
     *
     * 
     */
    @Test
    public void activityGetTest()  {
        String type = null;
        api.activityGet(type);


        // TODO: test validations
    }
    
}
