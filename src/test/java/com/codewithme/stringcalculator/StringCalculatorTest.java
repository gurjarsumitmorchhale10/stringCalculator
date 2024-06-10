package com.codewithme.stringcalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testAdd_should_return_zero_if_input_is_empty() {
        //Act
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void testAdd_should_return_argumentIntValue_if_input_is_single_argument() {
        assertEquals(1, stringCalculator.add("1"));
        assertEquals(5, stringCalculator.add("5"));
        assertEquals(11, stringCalculator.add("11"));
    }
}