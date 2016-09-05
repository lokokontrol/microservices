package es.imcs.intellipay.payments.boundary;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.imcs.intellipay.payments.entity.Payer;

public interface PayerService {
	
	Payer add(Payer payer);
	boolean delete(Long idPayment);
	List<Payer> findAll();
	List<Payer> findHandler(String lastname);

}
