package com.example.testMaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class TestMavenApplication {

	public static void main(String[] args) {
		System.out.println("Pars Tamin");
		SpringApplication.run(TestMavenApplication.class, args);
	}

}
