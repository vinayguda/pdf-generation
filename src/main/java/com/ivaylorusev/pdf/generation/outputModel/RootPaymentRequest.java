/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivaylorusev.pdf.generation.outputModel;

import com.ivaylorusev.pdf.generation.model.CustomerInformation;
import com.ivaylorusev.pdf.generation.model.InvoiceData;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

/**
 *
 * @author Ivaylo Rusev
 */
@Getter
@XmlRootElement
public class RootPaymentRequest {
    
    private String orderIdentifier;
    private Date orderDate;
    private InvoiceData invoiceData;
    private List<MapPaymentRequest> mapPaymentRequest;
    private CustomerInformation mapCustomerInformation;

    @XmlElement
    public void setOrderIdentifier(String orderIdentifier) {
        this.orderIdentifier = orderIdentifier;
    }

    @XmlElement
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @XmlElement
    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }

    @XmlElement
    public void setMapCustomerInformation(CustomerInformation mapCustomerInformation) {
        this.mapCustomerInformation = mapCustomerInformation;
    }
    
    @XmlElement
    public void setMapPaymentRequest(List<MapPaymentRequest> mapPaymentRequest) {
        this.mapPaymentRequest = mapPaymentRequest;
    }
    
}
