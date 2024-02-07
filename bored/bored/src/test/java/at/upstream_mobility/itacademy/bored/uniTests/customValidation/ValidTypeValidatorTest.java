package at.upstream_mobility.itacademy.bored.uniTests.customValidation;

import at.upstream_mobility.itacademy.bored.customValidation.ValidTypeValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ValidTypeValidatorTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;
    @InjectMocks
    private ValidTypeValidator validTypeValidator;
    private AutoCloseable closeable;

    @BeforeEach
    void initService() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @ParameterizedTest
    @CsvSource({
            "education, true",
            "recreational, true",
            "social, true",
            "diy, true",
            "charity, true",
            "cooking, true",
            "relaxation, true",
            "music, true",
            "busywork, true",
            "invalid1, false",
            "123, false",
            "@!., false",
    })
    void test_type_isValid(String value, boolean expectedResult) {
        // Act
        boolean isValid = validTypeValidator.isValid(value, constraintValidatorContext);

        // Assert
        assertEquals(expectedResult, isValid);
    }
}
