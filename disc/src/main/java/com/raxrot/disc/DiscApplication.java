package com.raxrot.disc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscApplication.class, args);
	}

}
