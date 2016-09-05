package es.imcs.intellipay.payments.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.imcs.intellipay.payments.boundary.PayerService;
import es.imcs.intellipay.payments.entity.Payer;

@Service
public class PayerServiceImp implements PayerService{
	
	@Autowired
	private PayerRepository payerRepo;

	@Transactional
	@HystrixCommand
	public Payer add(Payer payer) {
		
		return payerRepo.save(payer);
	}

	public boolean delete(Long idPayer) {
		boolean delete = false;
		
		if (idPayer != null) {
			payerRepo.delete(idPayer);
			delete = true;
		}
		return delete;
	}

	@Transactional
	@HystrixCommand(fallbackMethod="getDefaultMessage")
	public List<Payer> findAll() {
		return payerRepo.findAll();
	}
	
	
	private String getDefaultMessage() {
		  return "Error in findAll, use fallbackMethod";
		}
	

	public List<Payer> findHandler(String lastname) {
		return payerRepo.findBylastnameStartsWithIgnoreCase(lastname);
	}
	
	
	
	

}
