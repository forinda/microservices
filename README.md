# microservices
docker-compose -f common.yml -f kafka_cluster.yml up.

docker ps

winpty docker run -it --network=host confluentinc/cp-kafkacat kafkacat -L -b localhost:19092



winpty docker run -it --network=host confluentinc/cp-kafkacat kafkacat -C -b localhost:19092 -t twitter-topic



  Kafka model will create and hold the Avro model that will hold the data that will be inserted into Kafka.
  Kafka admin will create Kafka topics programmatically and also check if topics are created.
  Kafka producer will include the Spring Kafka dependency and related implementation that will help you to write the logic to insert the data into Kafka topics.
  
  
  
  
  
export JASYPT_ENCRYPTOR_PASSWORD='Demo_Pwd!2020'
echo $JASYPT_ENCRYPTOR_PASSWORD


winpty  docker exec -t 50e8f151251e /bin/bash

dos2unix [filename] --->exec /usr/local/bin/check-config-server-started.sh: no such file or directory

