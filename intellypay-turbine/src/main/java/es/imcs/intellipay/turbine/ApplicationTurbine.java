package es.imcs.intellipay.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@EnableHystrixDashboard
@EnableTurbine
public class ApplicationTurbine {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTurbine.class, args);
	}

}
