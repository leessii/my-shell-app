package at.upstream_mobility.itacademy.bored.client;

import org.openapitools.client.model.ActivityResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Qualifier("webClient")
public class BoredWebClient implements BoredApiClient {
    private final WebClient client;

    // Build the WebClient
    public BoredWebClient() {
        client = WebClient.builder()
                .baseUrl("https://www.boredapi.com/api/activity")
                .defaultHeader("Accept", "application/json")
                .build();
    }

    @Override
    public Mono<ActivityResponse> getActivity(String type) {
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("type", type)
                        .build())
                .retrieve()
                .bodyToMono(ActivityResponse.class);
    }
}
