package com.example.serverchainsleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author cowwa
 */
@EnableDiscoveryClient
@EnableZipkinServer
@SpringBootApplication
public class ServerChainSleuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerChainSleuthApplication.class, args);
	}


}
