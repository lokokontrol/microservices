package es.imcs.intellipay.payments.control;

import org.springframework.stereotype.Service;

import es.imcs.intellipay.payments.boundary.PaymentDTO;
import es.imcs.intellipay.payments.boundary.PaymentMapper;
import es.imcs.intellipay.payments.entity.Payer;
import es.imcs.intellipay.payments.entity.Payment;

@Service
public class PaymentMapperImp implements PaymentMapper {

	public Payment fromDto(PaymentDTO paymentDTO) {
		Payment payment = new Payment();
		payment.setIntent(paymentDTO.getIntent());
		payment.setState(paymentDTO.getState());
	//	payment.setTransactions(paymentDTO.getTransactions());
		payment.setPayer(Payer.builder().payerId(paymentDTO.getIdPayer()).build());
		return payment;
	}

	public PaymentDTO fromEntity(Payment payment) {
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setIdPayer(payment.getPayer().getPayerId());
		paymentDTO.setIntent(payment.getIntent());
		paymentDTO.setState(payment.getState());
		//paymentDTO.setTransactions(payment.getTransactions());
		return paymentDTO;
	}

}
