package com.ivaylorusev.pdf.generation.model;

import com.ivaylorusev.pdf.generation.model.enums.MailType;
import com.ivaylorusev.pdf.generation.model.enums.PaymentReminderDays;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Petya Marinova
 */
@Getter
@Setter
public class BillingEngineRelated {


    private MailType mailType;

    private PaymentReminderDays paymentReminderDays;

    private Boolean fileAttached;

    private BigDecimal paymentAmount;

    private BigDecimal underPaymentDifference;

    private BigDecimal overPaymentDifference;


}