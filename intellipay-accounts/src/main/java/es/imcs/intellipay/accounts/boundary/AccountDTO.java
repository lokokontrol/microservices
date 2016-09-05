package es.imcs.intellipay.accounts.boundary;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class AccountDTO {
    
  
    private Long idAccount;

    /**
     * The type of account to create. Allowed values: Personal - Personal
     * account Business - Business account
     */
    
    @NotEmpty(message = "account Type can't be empty")   
    private String accountType;

  
    @Size(min = 3, max=3)
    private String citizenshipCountryCode;

    /**
     * Contact phone number of the holder of the new account. Required
     */
    @NotNull(message="Please insert a contact phone number")
    @Size(min = 9, message = "phone number must be 9 characters long.")
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
    @Size(min = 3, max=3)
    private String currencyCode;

    /**
     * Required
     */
    @NotNull
    private String dateOfBirth;

    /**
     * Email address of the holder of the new Intellipay account
     */
    
    @Email(message="Wrong email!")
    private String email;

}



