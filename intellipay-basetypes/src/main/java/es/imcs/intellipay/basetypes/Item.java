package es.imcs.intellipay.basetypes;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Item {

	/**
	 * number of a particular item. 10 digits max. Required.
	 */
	private Integer quantity;
	
	/**
	 * item name. 127 characters max. Required.
	 */
	private String name;
	
	/**
	 * Item cost.
	 */
	private BigDecimal price;
	
	/**
	 * 3-letter currency code
	 */
	private String currency;
	
	/**
	 * Stock keeping unit corresponding (SKU) to item. 50 characters max.
	 */
	private String sku;
	
	/**
	 * Description of the item. O
	 * only supported when the payment_method is set to intellipay. 
	 * 127 characters max.
	 */
	private String description;
	
	/**
	 * Tax of the item. 
	 * Only supported when the payment_method is set to intellipay
	 */
	private BigDecimal tax;
	
	
}
