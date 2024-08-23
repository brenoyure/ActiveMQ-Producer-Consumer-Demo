#!/bin/bash
cd ./jms-consumer
mvn clean package
docker compose cp ./target/*.war jms-consumer:/opt/jboss/wildfly/standalone/deployments/
cd ..
