package es.imcs.intellipay.payments.entity;



import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import es.imcs.intellipay.basetypes.Name;
import es.imcs.intellipay.basetypes.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor

@Builder
public class PayerInfo {

	/**
	 * Email address representing the payer. 
	 * 127 characters max.
	 */
	private String email;
	
	//@Embedded
	//private Name data = new Name();

	//Now, its Payer's field.
	//private String payerId;
	
	/**
	 * Phone number representing the payer. 
	 * 20 characters max.
	 */
	private String phone;
	
	/**
	 * two-letter registered country code of the payer 
	 * to identify the buyer country.
	 */
	private String countryCode;
	
	/**
	 * shipping address of payer intellipay account
	 */
	@Embedded
	private ShippingAddress shippingAddress;
	
	
}
