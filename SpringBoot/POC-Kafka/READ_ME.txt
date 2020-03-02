

############### READ_ME ######################

First of all I am using Kafka version : 1.0.2

Please extract attached folder.
 
And Import below project in eclipes. 
1. kafka-producer-poc
2. kafka-consumer-poc

Both project developed using Spring Boot.

Please excute below command in different command prompt.

1. F:\Software\apache_kafka\kafka_2.12-2.0.0\bin\windows>zookeeper-server-start.bat ..\..\config\zookeeper.properties

2. F:\Software\apache_kafka\kafka_2.12-2.0.0\bin\windows>kafka-server-start.bat ..\..\config\server.properties

3. F:\Software\apache_kafka\kafka_2.12-2.0.0\bin\windows>kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic name-topic --from-beginning

Please start below projects.

1. kafka-producer-poc
2. kafka-consumer-poc

Please hit below url from kafka-producer-poc project.

http://localhost:8080/producer/{name}

here {name} as a message

After hit above URL Please check console of both Projects.
You can see {name} in Produced Message from kafka-producer-poc.
And same message {name} consumed in kafka-consumer-poc.

 