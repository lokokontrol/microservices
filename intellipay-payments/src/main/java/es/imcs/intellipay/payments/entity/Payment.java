package es.imcs.intellipay.payments.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
public class Payment {
	
	/**
	 * ID of the created payment
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Source of the funds for this payment represented by a 
	 * Intellipay account or a direct credit card. Required.
	 */
	@ManyToOne
	@JoinColumn(name="PAYER_ID")
	private Payer payer;
	
	
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
	//@ElementCollection
	//private List<Transaction> transactions;
	@Embedded
	private Transaction transaction;

}
