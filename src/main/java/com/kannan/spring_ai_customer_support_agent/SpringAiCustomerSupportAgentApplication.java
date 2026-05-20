package com.kannan.spring_ai_customer_support_agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SpringAiCustomerSupportAgentApplication {

	public static void main(String[] args) {

        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        SpringApplication.run(SpringAiCustomerSupportAgentApplication.class, args);
	}

}
