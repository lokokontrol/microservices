package es.imcs.intellipay.accounts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
public class Account {

    /**
     * Account id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The type of account to create. Allowed values: Personal - Personal
     * account Business - Business account
     */
    private String accountType;

    /**
     * the address of the holder of the new Intellipay account
     */
    //@Embedded
    //private Address address;

    /**
     * required if creating a business account
     */
    //@Embedded
    //private BusinessInfo businessInfo;

    /**
     * Code identifying the country of citizenship of the holder of the new
     * account
     */
    private String citizenshipCountryCode;

    /**
     * Contact phone number of the holder of the new account. Required
     */
    private String contactPhoneNumber;

    /**
     * Mobile phone number of the holder of the new account You must pass a
     * value for this parameter in order to use the "mobile confirmation" option
     * Optional
     */
    private String mobilePhoneNumber;

    /**
     * Three-letter code identifying the currency to assign to the new account
     */
    private String currencyCode;

    /**
     * Required
     */
    private String dateOfBirth;

    /**
     * Email address of the holder of the new Intellipay account
     */
    private String email;
    
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
    
    /**
     * The name of the business for which the Intellipay account is created
     */
    private String businessName;

    /**
     * The type of the business for which the Intellipay account is created.
     * Allowable values are CORPORATION GOVERNMENT INDIVIDUAL NONPROFIT
     * PARTNERSHIP PROPRIETORSHIP
     */
    private String businessType;
    
    @Override
    public String toString(){
	return this.accountType + " " + this.citizenshipCountryCode;
    }


}
