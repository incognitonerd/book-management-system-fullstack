package com.livedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.livedemo")
public class RunApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(RunApp.class);

	public static void main(String[] args) {
		SpringApplication.run(RunApp.class, args);
	}
}
