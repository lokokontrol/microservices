package es.imcs.intellipay.basetypes;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Name {

    /**
     * Salutation
     */
    public String salutation;
    /**
     * First name
     */
    public String firstName;
    /**
     * Last name
     */
    public String lastName;
    /**
     * Suffix of the payer.
     */
    public String suffix;

}