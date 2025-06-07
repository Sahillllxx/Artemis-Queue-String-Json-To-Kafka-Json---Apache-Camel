# Artemis Queue String JSON To Kafka JSON - Apache Camel

Welcome to the **Artemis Queue String JSON To Kafka JSON** project! This repository provides an Apache Camel-based solution for transferring and transforming JSON string messages from an Artemis Queue to a Kafka topic. The integration is robust, scalable, and designed for real-time message streaming and processing.

## 🚀 Features

- **Message Ingestion**: Seamlessly consumes messages from an Artemis Queue.
- **Data Transformation**: Converts String-based JSON to Kafka-compatible JSON format.
- **Kafka Integration**: Publishes transformed messages to specified Kafka topics.
- **Apache Camel Routing**: Flexible and easily customizable integration routes.
- **Error Handling**: Basic logging and fault tolerance built-in.

## 🛠️ Prerequisites

- **Java 8+**
- **Apache Maven**
- **Apache Camel** (pre-configured in this project)
- **Artemis MQ** (running instance)
- **Apache Kafka** (running broker)

## 📦 Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Sahillllxx/Artemis-Queue-String-Json-To-Kafka-Json---Apache-Camel.git
   cd Artemis-Queue-String-Json-To-Kafka-Json---Apache-Camel
   ```

2. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

3. **Configure your Artemis and Kafka connection settings:**
   - Update `application.properties` or `camel-context.xml` with your broker URLs, queues, and topics.

## ▶️ Usage

1. **Start Artemis MQ and Kafka Brokers**  
   Make sure both Artemis and Kafka are running and accessible.

2. **Run the Camel application:**
   ```bash
   mvn spring-boot:run
   ```

3. **Sending Test Messages:**  
   Send JSON string messages to your configured Artemis Queue. They will be routed, transformed, and published to the configured Kafka topic.

## ⚙️ Configuration

Edit the relevant configuration file (e.g., `application.properties` or `camel-context.xml`) to set:

- **Artemis Queue connection URL**
- **Kafka broker URL**
- **Source queue and target topic names**

Example (application.properties):
```properties
artemis.broker.url=tcp://localhost:61616
artemis.queue.name=your.source.queue
kafka.bootstrap.servers=localhost:9092
kafka.topic.name=your.target.topic
```

## 🧩 Camel Route Overview

Below is a simplified Camel route example:
```java
from("artemis:queue:{{artemis.queue.name}}")
    .routeId("ArtemisToKafkaRoute")
    .unmarshal().json(JsonLibrary.Jackson)
    .to("kafka:{{kafka.topic.name}}?brokers={{kafka.bootstrap.servers}}");
```

- **Input**: Artemis Queue with String JSON messages
- **Processing**: Unmarshalling and (optional) transformation
- **Output**: Kafka Topic

## 💡 Customization

- Add processors or beans for custom transformation logic.
- Implement advanced error handling as needed.
- Extend to additional endpoints (e.g., REST, file, etc.) using Camel components.

## 📖 Documentation

- [Apache Camel Documentation](https://camel.apache.org/manual/latest/)
- [Apache Artemis](https://activemq.apache.org/components/artemis/)
- [Apache Kafka](https://kafka.apache.org/documentation/)

## 📬 Contact

For questions or support, please open an issue on this repository or contact [@Sahillllxx](https://github.com/Sahillllxx).

---

**Happy Integrating with Apache Camel!**
