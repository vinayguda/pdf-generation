package com.ivaylorusev.pdf.generation.model;

import com.ivaylorusev.pdf.generation.model.enums.PaymentCondition;
import com.ivaylorusev.pdf.generation.model.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Petya Marinova
 */
@Getter
@Setter
public class PaymentData {

    private String paymentCurrencyCode;

    private BigDecimal paymentAmount;

    private PaymentType paymentType;

    private PaymentCondition paymentCondition;

    private String uniqueReference;

    private String partnerReference;

    private String programCode;

    private String accno;

    private String merchantAccno;

    private Date localDate;
}