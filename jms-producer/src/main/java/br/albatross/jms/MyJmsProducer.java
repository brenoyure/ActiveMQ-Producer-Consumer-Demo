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

    public void send(String assunto, String message) {

        Email email = EmailFactoryBean.newInstance();
        email.setAssunto(assunto);
        email.setCorpoDaMensagem(message);
        ObjectMessage emailJmsObjectMessage = context.createObjectMessage(email);
        System.out.println("Produzindo a mensagem com o assunto: " + assunto);
        System.out.println("Produzindo a mensagem com o texto: " + message);
        context.createProducer().send(queue, emailJmsObjectMessage);

    }

}
