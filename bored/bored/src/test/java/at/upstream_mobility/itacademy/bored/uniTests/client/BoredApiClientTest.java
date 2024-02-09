package at.upstream_mobility.itacademy.bored.uniTests.client;

import at.upstream_mobility.itacademy.bored.client.BoredApiClient;
import at.upstream_mobility.itacademy.bored.client.BoredWebClient;
import at.upstream_mobility.itacademy.bored.client.GenWebClient;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openapitools.client.model.ActivityResponse;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class BoredApiClientTest {

    static BoredApiClient[] provideBoredApiClients() {
        return new BoredApiClient[] {
                new BoredWebClient(),
                new GenWebClient()
        };
    }

    @ParameterizedTest
    @MethodSource("provideBoredApiClients")
    void getActivity_success(BoredApiClient boredApiClient) {
        // Arrange
        String[] wordsToCheck = {"[ACTIVITY]", "[PRICE]", "[TYPE]", "[PARTICIPANTS]", "[ACCESSIBILITY]", "diy"};
        String type = "diy";

        // Act
        Mono<ActivityResponse> response = boredApiClient.getActivity(type);
        String result = response.block().toString();

        // Assert
        for (String word : wordsToCheck) {
            assertTrue(result.contains(word), "Missing " + word);
        }
    }

    @ParameterizedTest
    @MethodSource("provideBoredApiClients")
    void getActivity_no_return_value(BoredApiClient boredApiClient) {
        // Arrange
        String[] wordsToCheck = {"[ACTIVITY]", "[PRICE]", "[TYPE]", "[PARTICIPANTS]", "[ACCESSIBILITY]"};
        String type = "not valid type";

        // Act
        Mono<ActivityResponse> response = boredApiClient.getActivity(type);
        ActivityResponse activityResponse = response.block();
        String result = activityResponse.toString();

        // Assert
        for (String word : wordsToCheck) {
            assertTrue(result.contains(word), "Missing " + word);
        }
        assertNull(activityResponse.getActivity(), "Activity should be null");
        assertNull(activityResponse.getPrice(), "Price should be null");
        assertNull(activityResponse.getType(), "Type should be null");
        assertNull(activityResponse.getParticipants(), "Participants should be null");
        assertNull(activityResponse.getAccessibility(), "Accessibility should be null");
    }
}