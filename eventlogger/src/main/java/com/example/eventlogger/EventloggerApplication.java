package com.example.eventlogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EventloggerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EventloggerApplication.class, args);
	}
}
