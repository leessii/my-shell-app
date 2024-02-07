package at.upstream_mobility.itacademy.bored.uniTests.commands;

import at.upstream_mobility.itacademy.bored.client.BoredApiClient;
import at.upstream_mobility.itacademy.bored.commands.ActivityCommands;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openapitools.client.model.ActivityResponse;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class ActivityCommandsTest {

    @Mock
    private BoredApiClient boredApiClientMock;
    @InjectMocks
    private ActivityCommands activityCommands;
    private AutoCloseable closeable;

    @BeforeEach
    void initService() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    public void test_getActivity_called_in_boredApiClient() {
        // Arrange
        // BoredApiClientMock behaviour
        ActivityResponse mockResponse = new ActivityResponse("Do something fun", "0.0", "diy", "1", "1.0");
        Mono<ActivityResponse> monoResponse = Mono.just(mockResponse);
        when(boredApiClientMock.getActivity(any())).thenReturn(monoResponse);
        String type = "diy";

        // Act
        activityCommands.getActivity(type);

        // Assert
        verify(boredApiClientMock, times(1)).getActivity(any());
    }

    @Test
    public void test_when_no_results_returned() {
        // Arrange
        // BoredApiClientMock behaviour
        ActivityResponse mockResponse = new ActivityResponse(null, null, null, null, null);
        Mono<ActivityResponse> monoResponse = Mono.just(mockResponse);
        when(boredApiClientMock.getActivity(any())).thenReturn(monoResponse);
        String type = "diy";
        String expected = "Sorry, the activity with your parameters does not exist. Change filter parameters.";

        // Act
        String result = activityCommands.getActivity(type);

        // Arrange
        verify(boredApiClientMock, times(1)).getActivity(any());
        assertEquals(expected, result);
    }

    @Test
    public void test_error_while_getting_activity() {
        // Arrange
        when(boredApiClientMock.getActivity(any()))
                .thenThrow(new RuntimeException("Simulated exception"));
        String type = "diy";
        String expected = "An error occurred while getting the activity: Simulated exception";

        // Act
        String result = activityCommands.getActivity(type);

        // Assert
        assertEquals(expected, result);
    }

}