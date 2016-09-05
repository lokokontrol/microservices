package es.imcs.intellipay.basetypes;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * Provides a list of items and the related 
 * shipping address within a transaction
 *
 */

@Embeddable
public class ItemList {
	
	@ElementCollection
	private List<Item> items;
	
	@Embedded
	private Address shippingAddress;
	
}
