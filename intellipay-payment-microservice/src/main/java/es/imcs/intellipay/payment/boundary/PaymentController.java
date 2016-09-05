package es.imcs.intellipay.payment.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.imcs.intellipay.payments.boundary.PayerService;
import es.imcs.intellipay.payments.boundary.PaymentService;
import es.imcs.intellipay.payments.entity.Payer;
import es.imcs.intellipay.payments.entity.Payment;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {
	
	@Autowired
	private PayerService payerService;
	
	@Autowired
	private PaymentService paymentService;
	

    @RequestMapping("/")
    public Payment home() {
        return new Payment();
    }
    
    @RequestMapping( value = "/payments", method = RequestMethod.GET)
    public List<Payment> getPayments() {
    	log.info("Entramos en /payments GET que nos da los Payments");
    	log.info(paymentService.findAll().toString());
        return paymentService.findAll();
    }
    
    @RequestMapping( value = "/payers", method = RequestMethod.GET)
    public List<Payer> getPayers() {
    	log.info("Entramos en /payers GET que nos da los Payers");
    	log.info(payerService.findAll().toString());
        return payerService.findAll();
    }
    
    @RequestMapping( value = "/payers", method = RequestMethod.POST)
    public Payer createPayer(@RequestBody Payer payer) {
    	log.info("Entramos en el PaymentController del Microservice");
    	log.info(payer.toString());
        return payerService.add(payer);   
    } 
    
    @RequestMapping( value = "/payers/hand", method = RequestMethod.GET)
    public List<Payer> getPayersHandled(@RequestBody String lastname) {
    	log.info("Entramos en el PaymentController del Microservice metodo Payers/hand");
        return payerService.findHandler(lastname);
    }
    
    @RequestMapping( value = "/payments", method = RequestMethod.POST)
    public Payment createPayment(@RequestBody Payment payment) {
    	log.info("Entramos en el PaymentController del Microservice");
    	log.info(payment.toString());
        return paymentService.add(payment);   
    } 
    

	
}
