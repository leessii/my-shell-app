package at.upstream_mobility.itacademy.bored.commands;

import at.upstream_mobility.itacademy.bored.model.ActivityType;
import org.springframework.shell.CompletionContext;
import org.springframework.shell.CompletionProposal;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ValueProvider;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ShellComponent
public class ActivityTypeValueProvider implements ValueProvider {

    @Override
    public List<CompletionProposal> complete(CompletionContext completionContext) {
        return Stream.of(ActivityType.values())
                .map(ActivityType::name)
                .map(String::toLowerCase)
                .map(CompletionProposal::new)
                .collect(Collectors.toList());
    }
}

