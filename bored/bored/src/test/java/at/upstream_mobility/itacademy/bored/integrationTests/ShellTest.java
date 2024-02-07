package at.upstream_mobility.itacademy.bored.integrationTests;

import at.upstream_mobility.itacademy.bored.client.BoredApiClient;
import at.upstream_mobility.itacademy.bored.commands.ActivityCommands;
import at.upstream_mobility.itacademy.bored.model.ActivityType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(properties = "spring.shell.interactive.enabled=false")
class ShellTest {

    @Autowired
    private ActivityCommands activityCommands;

    @Test
    public void test_shell_integration_success() {
        // Arrange
        String[] wordsToCheck = {"[ACTIVITY]", "[PRICE]", "[TYPE]", "[PARTICIPANTS]", "[ACCESSIBILITY]", "diy"};
        String type = "diy";

        // Act
        String result = activityCommands.getActivity(type);

        // Assert
        for (String word : wordsToCheck) {
            assertTrue(result.contains(word), "Missing " + word);
        }
    }


    @Test
    public void test_shell_integration_no_activity_found() {
        // Arrange
        String type = "not valued tye";
        String expected = "Sorry, the activity with your parameters does not exist. Change filter parameters.";

        // Act
        String result = activityCommands.getActivity(type);

        // Assert
        assertEquals(expected, result);
    }

}