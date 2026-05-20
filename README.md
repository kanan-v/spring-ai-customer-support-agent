# Spring AI Customer Support Agent 🤖📘

AI-powered customer support agent built using Spring AI, Ollama, PGVector, and PostgreSQL.

This project demonstrates a hybrid AI architecture combining:
- Retrieval-Augmented Generation (RAG)
- Tool Calling / AI Agents
- Semantic Search
- Autonomous Action Execution

The assistant can:
- answer questions using a user manual PDF
- execute actions like restarting routers
- autonomously decide whether to retrieve knowledge or use tools

---

# 🚀 Features

- PDF-based RAG pipeline
- Semantic search using vector embeddings
- AI agent with tool calling
- Router restart automation tool
- PGVector vector database integration
- Local LLM using Ollama
- Spring AI advisor architecture
- Hybrid retrieval + action workflow

---

# 🧠 How It Works

The application combines two major AI capabilities:

## 1️⃣ Knowledge Retrieval (RAG)

User questions are answered using:
- PDF ingestion
- embeddings
- vector similarity search

Example:

```text
User: How do I reset my router?
```

The AI retrieves relevant manual sections and answers accurately.

---

## 2️⃣ Tool Calling (Agent Actions)

If the user requests an action:

```text
User: My internet is down, restart my router.
```

the AI autonomously calls:

```java
rebootRouter()
```

tool to simulate router restart.

---

# 🏗️ Architecture

```text
                User Question
                      ↓
                ChatClient
                      ↓
          ┌───────────┴───────────┐
          ↓                       ↓
       RAG                    Tools
          ↓                       ↓
   User Manual PDF         rebootRouter()
          ↓                       ↓
     Retrieved Docs        Action Execution
          ↓                       ↓
          └───────────┬───────────┘
                      ↓
               Final AI Response
```

---

# 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring AI
- Ollama
- PostgreSQL
- PGVector
- Apache Tika
- Maven
- Docker

---

# 📂 Project Structure

```text
src/main/java/com/kannan/customer_support_agent
│
├── controller
│   └── SupportController.java
│
├── service
│   ├── ManualLoader.java
│   ├── SupportAgentService.java
│   └── RouterTools.java
│
└── CustomerSupportAgentApplication.java
```

---

# ⚙️ Setup Instructions

## 1️⃣ Clone Repository

```bash
git clone https://github.com/kanan-v/spring-ai-customer-support-agent.git
cd spring-ai-customer-support-agent
```

---

## 2️⃣ Start PostgreSQL + PGVector

```bash
docker run --name support-db \
-e POSTGRES_USER=my-user \
-e POSTGRES_PASSWORD=password \
-e POSTGRES_DB=support_db \
-p 5435:5432 \
-d pgvector/pgvector:0.8.1-pg18-trixie
```

---

## 3️⃣ Install Ollama

Download:

https://ollama.com/

---

## 4️⃣ Start Ollama

```bash
ollama serve
```

---

## 5️⃣ Pull Required Models

```bash
ollama pull qwen2.5
ollama pull nomic-embed-text
```

---

# ⚙️ Configure Application

`application.yaml`

```yaml
spring:
  application:
    name: customer-support-agent

  datasource:
    url: jdbc:postgresql://localhost:5435/support_db
    username: my-user
    password: password

  ai:
    ollama:
      base-url: http://localhost:11434

      chat:
        model: qwen2.5

      embedding:
        model: nomic-embed-text

    vectorstore:
      pgvector:
        initialize-schema: true
```

---

# 📄 PDF Ingestion

Place:

```text
manual.pdf
```

inside:

```text
src/main/resources/
```

On startup:
- PDF is read
- split into chunks
- embedded
- stored in PGVector

---

# ▶️ Run Application

```bash
./mvnw spring-boot:run
```

---

# 🎯 Example APIs

---

## 📘 RAG Example

### Request

```http
GET /support?question=How do I reset my router?
```

### Response

```text
Press and hold the reset button for 10 seconds.
```

---

## 🤖 Tool Calling Example

### Request

```http
GET /support?question=My internet is down, restart my router serial number ABC123
```

### AI Agent Behavior

The LLM autonomously:
1. Understands intent
2. Chooses rebootRouter() tool
3. Executes tool
4. Generates final response

### Response

```text
Your router has been restarted successfully.
```

---

# 🔍 Console Logs

```text
Rebooting router: ABC123
```

---

# 📊 Concepts Demonstrated

- Retrieval-Augmented Generation (RAG)
- Vector Databases
- Embeddings
- Semantic Search
- Tool Calling
- AI Agents
- Autonomous Decision Making
- Hybrid AI Systems
- Spring AI Advisors
- PGVector Integration

---

# 🧪 Future Improvements

- Multi-tool support
- Ticket generation
- Human escalation
- Multi-document RAG
- Conversation memory
- Authentication
- Frontend dashboard
- Streaming AI responses

---

# 👨‍💻 Author

Kannan V

---

# ⭐ If you found this useful

Give this repository a star ⭐
