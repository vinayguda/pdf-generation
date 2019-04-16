package com.ivaylorusev.pdf.generation.model;

import com.ivaylorusev.pdf.generation.model.enums.PositionType;
import lombok.Getter;
import lombok.Setter;


/**
 * @author Petya Marinova
 */
@Getter
@Setter
public class OrderPosition {

    private PositionType positionType;

    private Integer positionNumber;

    private ArticleLicense articleLicense;
    private AdditionalItemData additionalItemData;
    private OrderPositionDependencies orderPositionDependencies;
}
