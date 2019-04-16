package com.ivaylorusev.pdf.generation.model;

import com.ivaylorusev.pdf.generation.model.enums.Brand;
import lombok.Getter;
import lombok.Setter;


/**
 * @author Petya Marinova
 */
@Getter
@Setter
public class AdditionalItemData {
    private String vin;

    private String modelName;

    private String modelCode;

    private Brand brand;

    private String enrolmentCountry;


}