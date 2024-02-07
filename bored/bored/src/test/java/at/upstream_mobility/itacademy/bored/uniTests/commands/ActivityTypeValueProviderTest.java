package at.upstream_mobility.itacademy.bored.uniTests.commands;

import at.upstream_mobility.itacademy.bored.commands.ActivityTypeValueProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.shell.CompletionContext;
import org.springframework.shell.CompletionProposal;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTypeValueProviderTest {
    @Mock
    private CompletionContext completionContextMock;
    @InjectMocks
    private ActivityTypeValueProvider activityTypeValueProvider;
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
    void test_ActivityTypeValueProvider_returns_all_the_values() {
        // Act
        List<CompletionProposal> results = activityTypeValueProvider.complete(completionContextMock);

        // Assert
        List<String> expectedValues = Arrays.asList(
                "education", "recreational", "social", "diy",
                "charity", "cooking", "relaxation", "music", "busywork");

        for (CompletionProposal result : results) {
            assertTrue(expectedValues.stream()
                    .anyMatch(expectedValue -> expectedValue.equalsIgnoreCase(result.value()))
            );
        }
    }
}