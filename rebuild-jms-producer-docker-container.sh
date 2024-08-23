#!/bin/bash

docker compose down jms-producer
cd jms-producer
mvn clean package
cd ..
docker compose build jms-producer
docker compose up -d jms-producer

