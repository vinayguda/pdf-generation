package com.ivaylorusev.pdf.generation.model;

import com.ivaylorusev.pdf.generation.model.enums.OrderSource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Petya Marinova
 */
@Getter
@XmlRootElement
public class PaymentRequest {
    
    private String orderIdentifier;

    private String orderShopCountry;

    private OrderSource orderSource;

    private Date orderDate;
    
    private String orderLanguageCode;

    private List<OrderPosition> orderPositions;
    
    private CustomerInformation customerInformation;
    
    private PaymentData paymentData;
    
    private BillingEngineRelated billingEngineRelated;
    
    private InvoiceData invoiceData;

    @XmlElement
    public void setOrderIdentifier(String orderIdentifier) {
        this.orderIdentifier = orderIdentifier;
    }

    @XmlElement
    public void setOrderShopCountry(String orderShopCountry) {
        this.orderShopCountry = orderShopCountry;
    }

    @XmlElement
    public void setOrderSource(OrderSource orderSource) {
        this.orderSource = orderSource;
    }

    @XmlElement
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @XmlElement
    public void setOrderLanguageCode(String orderLanguageCode) {
        this.orderLanguageCode = orderLanguageCode;
    }

    @XmlElement
    public void setOrderPositions(List<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }

    @XmlElement
    public void setCustomerInformation(CustomerInformation customerInformation) {
        this.customerInformation = customerInformation;
    }

    @XmlElement
    public void setPaymentData(PaymentData paymentData) {
        this.paymentData = paymentData;
    }

    @XmlElement
    public void setBillingEngineRelated(BillingEngineRelated billingEngineRelated) {
        this.billingEngineRelated = billingEngineRelated;
    }

    @XmlElement
    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }
    

}
