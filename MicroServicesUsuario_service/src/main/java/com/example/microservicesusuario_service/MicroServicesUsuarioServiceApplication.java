package com.example.microservicesusuario_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroServicesUsuarioServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServicesUsuarioServiceApplication.class, args);
    }

}
