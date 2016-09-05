package es.imcs.intellipay.basetypes;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
public class AmountDetails {
	
	/**
	 * Amount charged for shipping.
	 * 10 characters max with support for 2 decimal places.
	 */
	private BigDecimal shipping;
	
	/**
	 * Amount of the subtotal of the items. 
	 * Required if line items are specified.
	 * 10 characters max, with support for 2 decimal places.
	 */
	private BigDecimal subtotal;
	
	/**
	 * Amount charged for tax. 
	 * 10 characters max with support for 2 decimal places.
	 */
	private BigDecimal tax;
	
	/**
	 * Amount being charged for the handling fee. 
	 * Only supported when the payment_method is set to intellipay
	 */
	private BigDecimal handlingFee;
	
	/**
	 * Amount being charged for the insurance fee.
	 * Only supported when the payment_method is set to intellipay.
	 */
	private BigDecimal insurance;
	
	/**
	 * Amount being discounted for the shipping fee. 
	 * Only supported when the payment_method is set to intellipay.
	 */
	private BigDecimal shippingDiscount;
	
	
	
}
