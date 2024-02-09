package at.upstream_mobility.itacademy.bored.customValidation.customException;

import jakarta.validation.ConstraintViolation;
import org.springframework.shell.ParameterValidationException;
import org.springframework.shell.command.CommandExceptionResolver;
import org.springframework.shell.command.CommandHandlingResult;
import org.springframework.stereotype.Component;


import java.util.stream.Collectors;

@Component
public class CustomExceptionHandler implements CommandExceptionResolver {

    @Override
    public CommandHandlingResult resolve(Exception ex) {
        if (ex instanceof ParameterValidationException) {
            return CommandHandlingResult.of(
                    ((ParameterValidationException) ex).getConstraintViolations()
                            .stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining(" / "))
                            +'\n', 1);
        }
        return CommandHandlingResult.of(ex.getMessage()+'\n', 0);
    }
}
