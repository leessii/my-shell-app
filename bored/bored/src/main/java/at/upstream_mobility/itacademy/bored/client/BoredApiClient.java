package at.upstream_mobility.itacademy.bored.client;

import org.openapitools.client.model.ActivityResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface BoredApiClient {
    Mono<ActivityResponse> getActivity(
            @RequestParam(required = false) String type
    );
}
