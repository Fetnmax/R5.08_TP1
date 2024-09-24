package com.maxime.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
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

    @AfterEach
    void tearDown() {
        calculator = null;
    }

}
