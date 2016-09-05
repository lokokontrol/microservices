package es.imcs.intellipay.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @see: http://cloud.spring.io/spring-cloud-static/docs/1.0.x/spring-cloud.html
 *       #spring-cloud-eureka-server
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
    	//new SpringApplicationBuilder(EurekaServerApplication.class).run(args);
    	SpringApplication.run(EurekaServerApplication.class, args);
    }
}
