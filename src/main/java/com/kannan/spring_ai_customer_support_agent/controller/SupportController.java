package com.kannan.spring_ai_customer_support_agent.controller;


import com.kannan.spring_ai_customer_support_agent.service.SupportAgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SupportController {

    private final SupportAgentService supportAgentService;

    @GetMapping("/support")
    public String support(
            @RequestParam String question
    ) {

        return supportAgentService.ask(question);
    }
}
