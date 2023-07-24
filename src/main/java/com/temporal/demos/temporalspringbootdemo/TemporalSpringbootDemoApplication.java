package com.temporal.demos.temporalspringbootdemo;

import ch.qos.logback.core.net.server.Client;
import io.temporal.client.WorkflowClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemporalSpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemporalSpringbootDemoApplication.class, args).start();
	}
}
