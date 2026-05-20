package com.kannan.spring_ai_customer_support_agent.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManualLoader {

    private final VectorStore vectorStore;

    @PostConstruct
    public void loadManual(){
        TikaDocumentReader reader = new TikaDocumentReader(new ClassPathResource("manual.pdf"));
        List<Document> documents = reader.get();
        TokenTextSplitter splitter =
                TokenTextSplitter.builder()
                        .withChunkSize(300)
                        .build();

        List<Document> splitDocs =
                splitter.apply(documents);

        vectorStore.add(splitDocs);

        System.out.println("Manual loaded into vector DB!");
    }

}
