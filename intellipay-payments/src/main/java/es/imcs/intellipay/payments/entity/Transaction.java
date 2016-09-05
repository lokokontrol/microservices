package es.imcs.intellipay.payments.entity;



import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import es.imcs.intellipay.basetypes.Amount;
import es.imcs.intellipay.basetypes.ItemList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
public class Transaction {

	/**
	 * Amount being collected . Required.
	 */
	@Embedded
	private Amount amount;
	
	/**
	 * Description of transaction. 
	 * 127 characters max.
	 */
	private String description;
	
	/**
	 * Items and related shipping address within a transaction.
	 */
	//@Embedded
	//private ItemList itemList;
	
	@Override
	public String toString(){
		return this.amount.toString() + " " + this.description;
	}
}
