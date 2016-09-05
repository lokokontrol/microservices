package es.imcs.intellipay.accounts.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import es.imcs.intellipay.basetypes.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class BusinessStakeHolder {

    /**
     * BusinessStakeHolder id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name of the stakeholder in the business for which the Intellipay account
     * is created
     */
    @Embedded
    private Name name;

    /**
     * occupation, meaning profession, of a business stakeholder
     */
    private String occupation;

    /**
     * The role of the stakeholder in the business for which the PayPal account
     * is created. Allowable values are: CHAIRMAN SECRETARY TREASURER
     * BENEFICIAL_OWNER PRIMARY_CONTACT INDIVIDUAL_PARTNER
     * NON_INDIVIDUAL_PARTNER PRIMARY_INDIVIDUAL_PARTNER DIRECTOR
     * NO_BENEFICIAL_OWNER
     */
    private String role;

}
