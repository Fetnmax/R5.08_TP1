package com.maxime.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Test
    void add_devrait_retourner_5_quand_2_et_3_sont_passes_en_parametres() {
        // Given
        int opG = 2;
        int opD = 3;

        // When
        int result = calculator.add(opG, opD);

        // Then
        assertEquals(5, result);
    }

    @Test
    void divide_devrait_retourner_2_quand_6_et_3_sont_passes_en_parametres() {
        // Given
        int opG = 6;
        int opD = 3;

        // When
        int result = calculator.divide(opG, opD);

        // Then
        assertEquals(2, result);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1, 1",
            "1, 2, 3",
            "-2, 2, 0",
            "0, 0, 0",
            "-1, -2, -3"
    })
    void add_parameterizedTest(int opG, int opD, int expectedResult) {
        // When
        int result = calculator.add(opG, opD);

        // Then
        assertEquals(expectedResult, result);
    }

}
