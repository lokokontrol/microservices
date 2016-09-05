package es.imcs.intellipay.basetypes;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
public class Amount {
	
	/**
	 * 3-letter currency code. 
	 * Intellipay does not support all currencies. Required.
	 */
	private String currency;
	
	/**
	 * Total amount charged from the payer to the payee. 
	 * In case of a refund, this is the refunded amount to the original payer from the payee. 
	 * 10 characters max with support for 2 decimal places.
	 */
	private String total;
	
	/**
	 * Additional details related to a payment amount
	 */
	//@Embedded
	//private AmountDetails details;
	
	@Override
	public String toString(){
		return total + " " + currency;
	}
}
