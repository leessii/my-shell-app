package at.upstream_mobility.itacademy.bored.uniTests.customValidation.customException;

import at.upstream_mobility.itacademy.bored.customValidation.customException.CustomExceptionHandler;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.shell.ParameterValidationException;
import org.springframework.shell.command.CommandHandlingResult;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CustomExceptionHandlerTest {
    @Mock
    private ConstraintViolation<Object> constraintViolation;
    @InjectMocks
    private CustomExceptionHandler customExceptionHandler;
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
    void test_resolve_ParameterValidationException() {
        // Arrange
        when(constraintViolation.getMessage()).thenReturn("Validation failed");
        ParameterValidationException parameterValidationException = new ParameterValidationException(Set.of(constraintViolation));
        String expectedErrorMessage = "Validation failed";

        // Act
        CommandHandlingResult result = customExceptionHandler.resolve(parameterValidationException);

        // Assert
        assertEquals(expectedErrorMessage, result.message().trim());
        assertEquals(1, result.exitCode());
    }

    @Test
    void test_resolve_OtherException() {
        // Arrange
        Exception otherException = new Exception("Some other exception message");
        String expectedErrorMessage = "Some other exception message";

        // Act
        CommandHandlingResult result = customExceptionHandler.resolve(otherException);

        // Assert
        assertEquals(expectedErrorMessage, result.message().trim());
        assertEquals(0, result.exitCode());
    }
}