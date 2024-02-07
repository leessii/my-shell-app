# DefaultApi

All URIs are relative to *https://www.boredapi.com:443/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**activityGet**](DefaultApi.md#activityGet) | **GET** /activity | Get events by type |



## activityGet

> activityGet(type)

Get events by type

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://www.boredapi.com/api");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        String type = "education"; // String | The type of event to filter
        try {
            apiInstance.activityGet(type);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#activityGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **type** | **String**| The type of event to filter | [optional] [enum: education, recreational, social, diy, charity, cooking, relaxation, music, busywork] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **404** | No activity found |  -  |

