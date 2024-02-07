package at.upstream_mobility.itacademy.bored.customValidation;

import at.upstream_mobility.itacademy.bored.model.ActivityType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.EnumSet;

public class ValidTypeValidator implements ConstraintValidator<ValidType, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value.isEmpty() || EnumSet.allOf(ActivityType.class)
                .stream()
                .anyMatch(enumConstant -> enumConstant.name().equalsIgnoreCase(value));
    }
}
