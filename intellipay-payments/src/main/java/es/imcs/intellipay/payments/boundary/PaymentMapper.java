package es.imcs.intellipay.payments.boundary;

import es.imcs.intellipay.payments.entity.Payment;

public interface PaymentMapper {
	
	Payment fromDto (PaymentDTO paymentDTO);
	PaymentDTO fromEntity (Payment payment);

}
