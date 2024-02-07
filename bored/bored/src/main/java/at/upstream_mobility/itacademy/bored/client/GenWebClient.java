package at.upstream_mobility.itacademy.bored.client;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.model.ActivityResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Qualifier("genWebClient")
public class GenWebClient implements BoredApiClient {
    private final DefaultApi defaultApi;
    public GenWebClient() {
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath("https://www.boredapi.com/api");

        defaultApi = new DefaultApi(defaultClient);
    }

    @Override
    public Mono<ActivityResponse> getActivity(String type) {

        return defaultApi.activityGet(type);
    }
}


