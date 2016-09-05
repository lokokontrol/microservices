package es.imcs.intellipay.payments.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;


import es.imcs.intellipay.payments.boundary.PaymentDTO;
import es.imcs.intellipay.payments.boundary.PaymentMapper;
import es.imcs.intellipay.payments.boundary.PaymentService;
import es.imcs.intellipay.payments.entity.Payer;
import es.imcs.intellipay.payments.entity.Payment;

@Service
public class PaymentServiceImp implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private PayerRepository payerRepository;
	
	@Autowired
	private PaymentMapper paymentMapper;

	@Transactional
	@HystrixCommand
	public Payment add(Payment payment) {
		
		//Payment payment = paymentMapper.fromDto(paymentDTO);
		return paymentRepository.save(payment);
	
	}
	
	@Transactional
	@HystrixCommand
	public boolean delete(Long idPayment) {
		
		boolean delete = false;
		
		if (idPayment != null) {
			paymentRepository.delete(idPayment);
			delete = true;
		}
		return delete;
	}

	@Transactional
	@HystrixCommand
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}	
		
	
}
