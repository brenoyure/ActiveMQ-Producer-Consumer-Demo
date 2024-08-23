package br.albatross.jms.consumer;

import org.jboss.ejb3.annotation.ResourceAdapter;

import br.albatross.apis.email.Email;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@ResourceAdapter("my-remote-jms-pooled-connection-factory")
@MessageDriven(activationConfig = {
//        @ActivationConfigProperty(propertyName = "user",                 propertyValue = "artemis"),
//        @ActivationConfigProperty(propertyName = "password",             propertyValue = "artemis"),
        @ActivationConfigProperty(propertyName = "destinationLookup",    propertyValue = "jms.queue.OtrsEmailQueue"),
        @ActivationConfigProperty(propertyName = "destinationType",      propertyValue = "jakarta.jms.Queue")
//        @ActivationConfigProperty(propertyName = "connectionParameters", propertyValue = "host=br.albatross.messaging.activemq-c;port=61616"),
//        @ActivationConfigProperty(propertyName = "connectorClassName",   propertyValue = "org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory") 
})
public class MyJmsConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Recebendo Mensagem...");
            System.out.println(message);

            Email receivedEmail = message.getBody(Email.class);

            System.out.println("Assunto do Email: " + receivedEmail.getAssunto());
            System.out.println("Corpo do Email: "   + receivedEmail.getCorpoDaMensagem());

        } catch (JMSException e) { throw new RuntimeException(e); }

    }

}
