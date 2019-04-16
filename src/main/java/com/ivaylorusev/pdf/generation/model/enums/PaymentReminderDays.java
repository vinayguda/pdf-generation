package com.ivaylorusev.pdf.generation.model.enums;


import java.util.Arrays;

/**
 * @author Petya Marinova
 */
public enum PaymentReminderDays {
    WEEK_1(7),
    WEEK_2(14),
    WEEK_3(21);
    private final int value;

    PaymentReminderDays(int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}