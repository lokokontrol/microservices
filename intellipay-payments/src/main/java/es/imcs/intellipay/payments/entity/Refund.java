package es.imcs.intellipay.payments.entity;



import es.imcs.intellipay.basetypes.Amount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Refund {

	/**
	 * ID of the refund transaction. 
	 * 17 characters max
	 */
	private Long id;
	
	/**
	 * Details including both refunded amount (to payer) and refunded fee (to payee). 
	 * 10 characters max.
	 */
	private Amount amount;
	
}
