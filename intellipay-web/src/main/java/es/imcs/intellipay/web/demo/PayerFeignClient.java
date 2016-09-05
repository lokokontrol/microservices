package es.imcs.intellipay.web.demo;

import java.util.Collection;
import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.imcs.intellipay.payments.entity.Payer;
import es.imcs.intellipay.payments.entity.Payment;

//@FeignClient(name="PayerFeignClient",url="http://localhost:8083")

@FeignClient("zuul")
public interface PayerFeignClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/payers")
    List<Payer> getPayers();
	
	@RequestMapping(method = RequestMethod.GET, value = "/payers/hand")
    List<Payer> getPayersHandled(String text);
	
	@RequestMapping(method = RequestMethod.POST, value = "/payers")
	Payer createPayer(Payer payer);
	
	@RequestMapping(method = RequestMethod.GET, value = "/payments")
    List<Payment> getPayments();
	
	@RequestMapping(method = RequestMethod.POST, value = "/payments")
	Payer createPayment(Payment payment);



}
