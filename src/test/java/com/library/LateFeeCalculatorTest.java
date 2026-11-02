package com.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LateFeeCalculatorTest {

    private LateFeeCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new LateFeeCalculator();
    }

    @Test
    void noFineForZeroDays() {
        assertEquals(0, calculator.calculateFine(0));
    }

    @Test
    void noFineBeforeFourteenDays() {
        assertEquals(0, calculator.calculateFine(7));
    }

    @Test
    void noFineAtThirteenDays() {
        assertEquals(0, calculator.calculateFine(13));
    }

    @Test
    void noFineAtFourteenDays() {
        assertEquals(0, calculator.calculateFine(14));
    }

    @Test
    void fineIsTwoForFifteenDays() {
        assertEquals(2, calculator.calculateFine(15));
    }

    @Test
    void fineIsFourForSixteenDays() {
        assertEquals(4, calculator.calculateFine(16));
    }

    @Test
    void fineIsTwentyForTwentyFourDays() {
        assertEquals(20, calculator.calculateFine(24));
    }

    @Test
    void fineIsFortyEightForThirtyEightDays() {
        assertEquals(48, calculator.calculateFine(38));
    }

    @Test
    void fineReachesFiftyAtThirtyNineDays() {
        assertEquals(50, calculator.calculateFine(39));
    }

    @Test
    void fineRemainsFiftyAtFortyDays() {
        assertEquals(50, calculator.calculateFine(40));
    }

    @Test
    void fineNeverExceedsFifty() {
        assertEquals(50, calculator.calculateFine(100));
    }

    @Test
    void negativeOneDayIsInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateFine(-1));
    }

    @Test
    void negativeTenDaysIsInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateFine(-10));
    }
}