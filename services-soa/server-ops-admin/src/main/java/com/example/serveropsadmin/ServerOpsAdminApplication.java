package com.example.serveropsadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cowwa
 */
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class ServerOpsAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerOpsAdminApplication.class, args);
	}

}
