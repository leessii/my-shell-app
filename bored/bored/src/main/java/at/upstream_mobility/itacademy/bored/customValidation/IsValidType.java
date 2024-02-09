package at.upstream_mobility.itacademy.bored.customValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsValidTypeValidator.class)
public @interface IsValidType {

    String message() default "Please provide a valid Type: [education, recreational, social, diy, charity, cooking, relaxation, music, busywork].";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
