package br.albatross.jms;

import br.albatross.apis.email.Email;
import br.albatross.apis.email.factory.EmailFactoryBean;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.JMSConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Queue;

@Stateless
public class MyJmsProducer {

    @Inject
    @JMSConnectionFactory("java:/jms/MyRemoteJmsConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "java:jboss/exported/jms/queue/OtrsEmailQueue")
    private Queue queue;

    public void send(String message) {
        Email email = EmailFactoryBean.newInstance();
        email.setAssunto("Enviando email para a fila JMS");
        email.setCorpoDaMensagem(message);
        ObjectMessage emailJmsObjectMessage = context.createObjectMessage(email);
        System.out.println(email.getAssunto());
        System.out.println(message);
        context.createProducer().send(queue, emailJmsObjectMessage);
    }

}
