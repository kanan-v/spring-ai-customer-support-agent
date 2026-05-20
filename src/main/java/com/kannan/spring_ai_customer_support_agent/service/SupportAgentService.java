package com.kannan.spring_ai_customer_support_agent.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupportAgentService {

    private final ChatClient.Builder chatClientBuilder;
    private final VectorStore vectorStore;
    private final RouterTools routerTools;

    public String ask(String question) {

        return chatClientBuilder.build()
                .prompt()
                .user(question)

                // RAG
                .advisors(
                        QuestionAnswerAdvisor.builder(vectorStore)
                                .build()
                )

                // TOOLS
                .tools(routerTools)

                .call()
                .content();
    }
}
