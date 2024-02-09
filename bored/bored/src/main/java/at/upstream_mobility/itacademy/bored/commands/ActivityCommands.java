package at.upstream_mobility.itacademy.bored.commands;

import at.upstream_mobility.itacademy.bored.client.BoredApiClient;
import at.upstream_mobility.itacademy.bored.customValidation.IsValidType;
import org.openapitools.client.model.ActivityResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ActivityCommands {
    private final BoredApiClient boredApiClient;

    public ActivityCommands(@Qualifier("genWebClient")BoredApiClient boredApiClient) {
        this.boredApiClient = boredApiClient;
    }

    @ShellMethod(key="get", value="Get an activity")
    public String getActivity(
            @ShellOption(
                    // Define option properties
                    defaultValue = "",
                    help = "Set activity type: [education, recreational, social, diy, charity, cooking, relaxation, music, busywork]",
                    valueProvider = ActivityTypeValueProvider.class
            )
            @IsValidType
            String type
    ) {
        try {
            ActivityResponse response = boredApiClient.getActivity(type).block();

            // Validation if the activity with the defined parameters does not exist
            if (response.getActivity() == null) {
                return "Sorry, the activity with your parameters does not exist. Change filter parameters.";
            }

            // Return the Activity
            return response.toString();

        } catch (Exception e) {
            return "An error occurred while getting the activity: " + e.getMessage();
        }
    }
}

