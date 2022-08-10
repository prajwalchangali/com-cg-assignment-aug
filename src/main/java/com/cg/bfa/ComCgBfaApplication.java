package com.cg.bfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ComCgBfaApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(ComCgBfaApplication.class);

	public static void main(String[] args) {
		
//		System.out.println("app");
		LOG.info("Start");
		SpringApplication.run(ComCgBfaApplication.class, args);
		LOG.info("Stop");
		
	}

}
