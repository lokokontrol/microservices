package es.imcs.intellipay.payments.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
public class Payer {
	
	/**
	 * Intellipay assigned Payer ID. 
	 * Value assigned by Intellipay
	 */
	@Id
	@GeneratedValue
	private Long payerId;
	
	/**
	 * Payment method used.
	 * Must be either credit_card or intellipay. Required.
	 */
	private String paymentMethod;
	
	//Metodo de Pago
	//private List<FundingInstrument> fundingInstruments;
	
	/**
	 * This object is pre-filled by Intellipay when the paymentMethod is intellipay
	 */
	//@Embedded
	//private PayerInfo payerInfo;
	
	private String name;
	private String lastname;
	private String phone;
	private String code;
	private String recipientName;
	
	@Override
	public String toString(){
		return this.name + " " + this.lastname;
	}


}
