package es.imcs.intellipay.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.imcs.intellipay.account.boundary.AccountController;
import es.imcs.intellipay.accounts.boundary.AccountService;
import es.imcs.intellipay.accounts.control.AccountRepository;
import es.imcs.intellipay.accounts.control.AccountServiceImpl;
import es.imcs.intellipay.accounts.entity.Account;

/**
 * @see: http://cloud.spring.io/spring-cloud-static/docs/1.0.x/spring-cloud.html
 *       #spring-cloud-eureka-server
 */

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses={AccountRepository.class})
@EntityScan(basePackageClasses = {Account.class})
@EnableEurekaClient
@ComponentScan(basePackageClasses={AccountService.class,AccountController.class,AccountServiceImpl.class})
public class AccountMicroserviceApplication {

    public static void main(String[] args) {
	SpringApplication.run(AccountMicroserviceApplication.class, args);
    }
   
}
