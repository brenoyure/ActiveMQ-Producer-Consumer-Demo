FROM quay.io/wildfly/wildfly:latest-jdk17
WORKDIR /opt/jboss/wildfly/
EXPOSE 8080
COPY config-jms-consumer.cli /tmp/

ARG JMS_QUEUE_HOST=${JMS_QUEUE_HOST}
ARG JMS_QUEUE_PORT=${JMS_QUEUE_PORT}
ARG JMS_QUEUE_USERNAME=${JMS_QUEUE_USERNAME}
ARG JMS_QUEUE_PASSWORD=${JMS_QUEUE_PASSWORD}

RUN ["/opt/jboss/wildfly/bin/jboss-cli.sh", "--file=/tmp/config-jms-consumer.cli", "--resolve-parameter-values"]
COPY target/*.war /opt/jboss/wildfly/standalone/deployments/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-c","standalone-full.xml"]
