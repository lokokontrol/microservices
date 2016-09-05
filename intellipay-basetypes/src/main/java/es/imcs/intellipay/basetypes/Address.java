package es.imcs.intellipay.basetypes;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
@Builder

public class Address {

    /**
     * Address type. Must be one of the following: residential, business, or
     * mailbox.
     */
    private String type;
    /**
     * Line 1 of the address (e.g., Number, street, etc). 100 characters max.
     * Required.
     */
    private String line1;
    /**
     * Line 2 of the address (e.g., Suite, apt #, etc). 100 characters max
     */
    private String line2;
    /**
     * City name. 50 characters max. Required.
     */
    private String city;
    /**
     * 2-letter country code. 2 characters max. Required.
     */
    private String countryCode;
    /**
     * Zip code or equivalent is usually required for countries that have them.
     * 20 characters max. Required in certain countries.
     */
    private String postalCode;
    /**
     * 2-letter code for US states, and the equivalent for other countries. 100
     * characters max.
     */
    private String state;
    /**
     * Phone number in E.123 format. 50 characters max.
     */
    private String phone;

}