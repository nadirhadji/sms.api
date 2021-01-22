package com.sms.sender.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import controller.WelcomeController;
import service.SMSServiceTwilio;

@SpringBootApplication
@ComponentScan(basePackageClasses = WelcomeController.class)
@EnableJpaRepositories(basePackages = {"repository"})
@EntityScan(basePackages = {"entity"})
public class SmsApplication {
	
	@Bean
    public SMSServiceTwilio smsbean() {
    	return new SMSServiceTwilio();
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}
}
