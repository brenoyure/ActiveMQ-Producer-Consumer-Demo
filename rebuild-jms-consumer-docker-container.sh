#!/bin/bash

docker compose down jms-consumer
cd jms-consumer
mvn clean package
cd ..
docker compose build jms-consumer
docker compose up -d jms-consumer

