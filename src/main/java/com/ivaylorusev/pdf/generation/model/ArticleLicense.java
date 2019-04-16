package com.ivaylorusev.pdf.generation.model;

import com.ivaylorusev.pdf.generation.model.enums.SalesItemGroup1;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Petya Marinova
 */
@Getter
@Setter
public class ArticleLicense {
    private String salesItemNumber;

    private String salesItemName;

    private Integer salesItemQuantity;

    private BigDecimal salesItemGrossAmount;

    private BigDecimal salesItemNetAmount;

    private BigDecimal salesItemVatAmount;

    private BigDecimal salesItemVatRate;

    private BigDecimal salesItemTotalGrossAmount;

    private BigDecimal salesItemTotalNetAmount;

    private BigDecimal salesItemTotalVatAmount;

    private SalesItemGroup1 salesItemGroup1;

    private String salesItemGroup2;
    private String salesItemGroup3;


    private Boolean waitForEnablement;

    private Date itemActivationDate;
    private Date itemExpirationDate;
    
    private String articleRunDuration;

}