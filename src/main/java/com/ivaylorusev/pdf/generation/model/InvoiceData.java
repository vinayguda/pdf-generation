package com.ivaylorusev.pdf.generation.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Nataliya Raykova
 */
@Getter
@Setter
public class InvoiceData {
    private String invoiceNumber;
    private Date invoiceDate;
    private BigDecimal invoiceNetAmount;
    private BigDecimal invoiceGrossAmount;
    private BigDecimal invoiceVat;
}
