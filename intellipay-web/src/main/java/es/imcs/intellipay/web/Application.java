package es.imcs.intellipay.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;


import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.boot.orm.jpa.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.imcs.intellipay.accounts.AccountMicroserviceRootcontext;
import es.imcs.intellipay.accounts.boundary.AccountService;
import es.imcs.intellipay.accounts.control.AccountMapperImp;
import es.imcs.intellipay.accounts.control.AccountRepository;
import es.imcs.intellipay.accounts.entity.Account;
import es.imcs.intellipay.payments.PaymentMicroserviceRootcontext;
import es.imcs.intellipay.payments.control.PaymentMapperImp;
import es.imcs.intellipay.payments.control.PaymentRepository;
import es.imcs.intellipay.payments.entity.Payer;
import es.imcs.intellipay.payments.entity.Payment;
import es.imcs.intellipay.web.demo.AccountUI;
import es.imcs.intellipay.web.demo.PayerUI;
import es.imcs.intellipay.web.demo.customer.Customer;
import es.imcs.intellipay.web.demo.customer.CustomerRepository;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses={PaymentRepository.class,AccountRepository.class})
@EntityScan(basePackageClasses={Payment.class, Customer.class , Payer.class, Account.class})
@ComponentScan(basePackageClasses={PaymentMicroserviceRootcontext.class, PaymentMapperImp.class, Application.class, 
				                   CustomerRepository.class, PayerUI.class, AccountMicroserviceRootcontext.class, 
				                   AccountMapperImp.class, AccountUI.class, AccountService.class} )
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
}
