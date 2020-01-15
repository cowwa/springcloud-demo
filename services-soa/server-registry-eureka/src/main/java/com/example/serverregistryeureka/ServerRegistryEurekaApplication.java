package com.example.serverregistryeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author cowwa
 */
@EnableEurekaServer
@SpringBootApplication
public class ServerRegistryEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerRegistryEurekaApplication.class, args);
	}

}
