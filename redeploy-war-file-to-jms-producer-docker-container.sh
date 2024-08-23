#!/bin/bash
cd ./jms-producer
mvn clean package
docker compose cp ./target/*.war jms-producer:/opt/jboss/wildfly/standalone/deployments/
cd ..
