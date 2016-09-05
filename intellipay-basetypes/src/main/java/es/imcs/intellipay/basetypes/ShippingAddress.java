package es.imcs.intellipay.basetypes;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ShippingAddress extends Address {
	
	/**
	 * Name of the recipient at this address. 
	 * 50 characters max. Required
	 */
	private String recipientName;

}
