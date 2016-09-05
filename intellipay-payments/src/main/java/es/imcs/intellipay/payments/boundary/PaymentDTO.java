package es.imcs.intellipay.payments.boundary;

import java.util.List;

import es.imcs.intellipay.payments.entity.Transaction;
import lombok.Data;

@Data
public class PaymentDTO {
	
	
	private Long idPayer;
	
	
	/**
	 * Payment state. Must be one of the following: 
	 * created, approved, failed, pending, canceled, expired, in_progress. 
	 */
	private String state;
	
	/**
	 * Payment intent. Must be set to sale for immediate payment, 
	 * authorize to authorize a payment for capture later, 
	 * or order to create an order. Required.
	 */
	private String intent;
	

	
	/**
	 * Transactional details including the amount and item details. Required.
	 */
	//private List<Transaction> transactions;
}
