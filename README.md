# kafka-websocket-stream

### This project demonstrates a live Kafka stream feed to the front end via a websocket.

This demo uses the following:
- Confluent Platform 5.0.0 (running on Java 8)
- Spring Boot Reactive Web + Spring Kafka (running on Java 10)
- STOMP Websocket Protocol
- JQuery + SockJS

Confluent is a platform distribution of Apache Kafka.  Some features that you see in Confluent are not available in the Apache Kafka base such as:
- KSQL - SQL engine for streaming Kafka topics
- Schema Registry - Serving layer for metadata required for integration between producers/consumers

Download Confluent Platform 5.0.0 from the following URL:
https://www.confluent.io/download/

Run the following commands in order to create the Kafka feed simulation:
1. <path-to-confluent>/bin/confluent start
2. <path-to-confluent>/bin/kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic pageviews
3. <path-to-confluent>/bin/ksql-datagen quickstart=pageviews format=delimited topic=pageviews maxInterval=5000

Run the following commands to start the project:
1. <path-to-project>/gradlew bootrun

In a web browser (ie. Chrome, Firefox, etc.), type in the following URL:
localhost:8080