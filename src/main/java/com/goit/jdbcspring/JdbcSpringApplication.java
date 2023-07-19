package com.goit.jdbcspring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcSpringApplication {
	Logger logger = LogManager.getLogger(JdbcSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JdbcSpringApplication.class, args);
	}


}
