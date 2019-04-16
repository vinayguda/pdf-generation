/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivaylorusev.pdf.generation.outputModel;

import com.ivaylorusev.pdf.generation.model.OrderPosition;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Ivaylo Rusev
 */
@Getter
@AllArgsConstructor
public class MapPaymentRequest {
    
    private String salesItemName;
    private String salesItemNumber;
    private List<OrderPosition> salesItems;

    public void setSalesItemName(String salesItemName) {
        this.salesItemName = salesItemName;
    }

    public void setSalesItemNumber(String salesItemNumber) {
        this.salesItemNumber = salesItemNumber;
    }
    
    public void setSalesItems(List<OrderPosition> salesItems) {
        this.salesItems = salesItems;
    }
    
}
