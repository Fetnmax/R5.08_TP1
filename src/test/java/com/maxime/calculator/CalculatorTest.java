package com.maxime.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void ensembleChiffres_devrait_retourner_1_quand_moins_1_1_est_passe_en_parametre() {
        // Given
        int pNombre = -11;

        // When
        Set<Integer> chiffres = calculator.ensembleChiffres(pNombre);

        // Then
        assertEquals(1, chiffres.size());
        assertTrue(chiffres.contains(1));
    }

    @Test
    void add_devrait_lancer_une_exception_quand_2_147_483_647_et_1_sont_passes_en_parametres() {
        // Given
        int opG = Integer.MAX_VALUE;
        int opD = 1;

        // When
        try {
            calculator.add(opG, opD);
        } catch (ArithmeticException e) {
            // Then
            assertEquals("Integer overflow", e.getMessage());
        }
    }

    @Test
    void divide_devrait_lancer_une_exception_quand_0_est_passé_en_paramètre_pour_opD() {
        // Given
        int opG = 6;
        int opD = 0;

        // When
        try {
            calculator.divide(opG, opD);
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Division par zéro impossible", e.getMessage());
        }
    }
}
