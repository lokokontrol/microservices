package es.imcs.intellipay.accounts.entity;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
@Builder
public class BusinessInfo {

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

    /**
     * The category describing the business for which the Intellipay account is
     * created, for example; 1004 for Baby
     */
    private String merchantCategoryCode;

    @OneToMany
    private List<BusinessStakeHolder> businessStakeHolders;

    /**
     * Specify YES if the business has directors, otherwise NO
     */
    private Boolean hasDirectors;

}
