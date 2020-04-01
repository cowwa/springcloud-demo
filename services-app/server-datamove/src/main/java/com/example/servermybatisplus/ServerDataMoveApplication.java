package com.example.servermybatisplus;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author cowwa
 */
@SpringBootApplication
@MapperScan(basePackages={"com.example.servermybatisplus.mapper"})
@EnableAsync
@ComponentScan(basePackages = {"com.example.servicescore.component","com.example.servermybatisplus"})
@Slf4j
public class ServerDataMoveApplication {

	public static void main(String[] args) throws UnknownHostException {
		System.setProperty("es.set.netty.runtime.available.processors","false");
		SpringApplication app = new SpringApplication(ServerDataMoveApplication.class);
		Environment env = app.run(args).getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\thttp://localhost:{}\n\t" +
						"External: \thttp://{}:{}\n\t" +
						"SwaggerUI: \thttp://localhost:{}/swagger-ui.html\n" +
						"----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				env.getProperty("server.port"));
	}

}
