-- Start Kafka Zookeeper Server (service registry)
-- Start Kafka Broker Server
-- Create Kafka Topic
-- Create Spring Boot Project with Kafka Configuration
-- Publish Message to Topic from Sprint Boot App
-- kafka clustering
-----------------------facility------------------
1. write 2 million data per seceond
2. logg aggregator
3. event sourcing for micro services
4. zero downtime

---------------------------------------------------------------------
kafka command after docker up 

1. // docker execute in interactive kakafa shell mode

docker exec -it kafka bin/sh

------------------------------------

2. ls
3. cd /opt/kafka

4. create topic run the command
-------------------------------------------------------------------

bin/kafka-topics.sh --create --topic mrk --bootstrap-server localhost:9092
-------------------------------------------------------------------------

5. to display usage information

bin/kafka-topics.sh --describe --topic mrk --bootstrap-server localhost:9092
---------------------------------------------------------------------------------

6. Write in kafka

bin/kafka-console-producer.sh --topic mrk --bootstrap-server localhost:9092
-----------------------------------------------------------------------------------

7. Read Kafka

bin/kafka-console-consumer.sh --topic mrk --from-beginning --bootstrap-server localhost:9092
