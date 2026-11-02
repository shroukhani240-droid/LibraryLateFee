package com.library;

public class LateFeeCalculator {

    private static final int FREE_DAYS = 14;
    private static final int FINE_PER_DAY = 2;
    private static final int MAX_FINE = 50;

    public int calculateFine(int borrowedDays) {

        if (borrowedDays < 0) {
            throw new IllegalArgumentException(
                    "Borrowed days cannot be negative.");
        }

        int lateDays = Math.max(0, borrowedDays - FREE_DAYS);

        int fine = lateDays * FINE_PER_DAY;

        return Math.min(fine, MAX_FINE);
    }
}