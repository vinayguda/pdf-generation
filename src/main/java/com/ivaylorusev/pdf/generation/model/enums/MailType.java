package com.ivaylorusev.pdf.generation.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Petya Marinova
 */
public enum MailType {
    ACTIVATION("activation"),
    ORDER_CONFIRMATION("order_confirmation"),
    LICENCE_EXPIRED("licence_expired"),
    NO_PAYMENT("no_payment"),
    REVOCATION("revocation"),
    REVOCATION_AGB("revocation_AGB"),
    NO_PAYMENT_WITHIN_GRACE_PERIOD("no_payment_within_grace_period"),
    NO_PAYMENT_END_OF_GRACE_PERIOD("no_payment_end_of_grace_period"),
    UNDER_PAYMENT_REMINDER("under_payment_reminder"),
    UNDER_PAYMENT_END_OF_GRACE_PERIOD("under_payment_end_of_grace_period"),
    OVER_PAYMENT_REMINDER("over_payment_reminder");

    private final String type;

    MailType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }


    @Override
    @JsonValue
    public String toString() {
        return type;
    }
}