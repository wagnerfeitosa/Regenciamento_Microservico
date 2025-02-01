package com.wg.controller_producao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ControllerProducaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerProducaoApplication.class, args);
	}

}
