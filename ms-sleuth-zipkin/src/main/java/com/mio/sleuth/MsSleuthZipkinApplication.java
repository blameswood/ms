package com.mio.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableZipkinStreamServer
@EnableZipkinServer
public class MsSleuthZipkinApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MsSleuthZipkinApplication.class, args);
	}
	
}
