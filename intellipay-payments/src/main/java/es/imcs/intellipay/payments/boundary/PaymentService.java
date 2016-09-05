package es.imcs.intellipay.payments.boundary;

import java.util.List;

import es.imcs.intellipay.payments.entity.Payment;

public interface PaymentService {
	
	Payment add(Payment paymentDTO);
	boolean delete(Long idPayment);
	List<Payment> findAll();

}
