package es.imcs.intellipay.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@Configuration
public class ConfigMicroserviceApplication {
   
   public static void main(String[] args) {
      SpringApplication.run(ConfigMicroserviceApplication.class, args);
      }

}