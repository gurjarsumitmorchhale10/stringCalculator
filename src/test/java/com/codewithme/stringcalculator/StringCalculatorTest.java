package com.codewithme.stringcalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchRuntimeException;
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

    @Test
    void testAdd_should_return_sum_of_all_arguments() {
        assertEquals(3, stringCalculator.add("1,2"));
        assertEquals(16, stringCalculator.add("5,4,7"));
        assertEquals(19, stringCalculator.add("8,5,2,4"));
    }

    @Test
    void testAdd_should_handle_newLine_delimiter_return_sum_of_all_arguments() {
        assertEquals(3, stringCalculator.add("1,2"));
        assertEquals(16, stringCalculator.add("5,4\n7"));
        assertEquals(19, stringCalculator.add("8,5,2\n4"));
    }

    @Test
    void testAdd_should_handle_given_delimiter_and_return_sum_of_arguments() {
        assertEquals(16, stringCalculator.add("//;\n5;4;7"));
        assertEquals(19, stringCalculator.add("//;\n8;5;2;4"));
    }

    @Test
    void testAdd_should_throw_exception_if_input_contains_negative_numbers() {
        RuntimeException invalidArgumentException = catchRuntimeException(() -> stringCalculator.add("1,-2"));
        assertThat(invalidArgumentException).isInstanceOf(InvalidArgumentException.class);
        assertThat(invalidArgumentException).hasMessageContaining("negative numbers not allowed: -2");
    }
}