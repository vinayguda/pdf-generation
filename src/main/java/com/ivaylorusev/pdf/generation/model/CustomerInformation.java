package com.ivaylorusev.pdf.generation.model;

import com.ivaylorusev.pdf.generation.model.enums.CustomerType;
import lombok.Getter;
import lombok.Setter;


/**
 * @author Petya Marinova
 */
@Getter
@Setter
public class CustomerInformation {

    private CustomerType customerType;

    private String email;
    private String company;

    private String firstName;

    private String lastName;
    private String postcode;
    private String salutation;

    private String addr1;
    private String houseNumber;
    private String addr2;
    private String addr3;

    private String city;
    private String state;
    private String countryCode;
    private String taxId;

}