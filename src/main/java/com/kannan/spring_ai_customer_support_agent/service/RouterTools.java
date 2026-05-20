package com.kannan.spring_ai_customer_support_agent.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class RouterTools {

    @Tool(description = "Restart a customer's router")
    public String rebootRouter(String serialNo) {

        System.out.println("Rebooting router: " + serialNo);

        return "Router with serial number " +
                serialNo +
                " restarted successfully.";
    }

}
