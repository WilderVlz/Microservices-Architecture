package com.microservice.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableFeignClients // we enable feign to consume the services of other microservices
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentApplication.class, args);
    }

}
