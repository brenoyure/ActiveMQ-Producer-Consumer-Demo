#!/bin/bash
docker compose down
cd jms-consumer
mvn clean package
cd ../jms-producer
mvn clean package
cd ..
docker compose build
docker compose up -d
