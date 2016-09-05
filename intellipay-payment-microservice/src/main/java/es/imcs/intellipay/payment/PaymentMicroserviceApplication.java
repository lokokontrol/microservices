package es.imcs.intellipay.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import es.imcs.intellipay.payment.boundary.PaymentController;
import es.imcs.intellipay.payments.boundary.PayerService;
import es.imcs.intellipay.payments.control.PayerServiceImp;
import es.imcs.intellipay.payments.control.PaymentRepository;
import es.imcs.intellipay.payments.entity.Payment;

/**
 * @see: http://cloud.spring.io/spring-cloud-static/docs/1.0.x/spring-cloud.html#spring-cloud-eureka-server
 */
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackageClasses={Payment.class})
@EnableJpaRepositories(basePackageClasses={PaymentRepository.class})
@ComponentScan(basePackageClasses={PayerService.class,PayerServiceImp.class,PaymentController.class})
@EnableEurekaClient
public class PaymentMicroserviceApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(PaymentMicroserviceApplication.class, args);
	}

}
