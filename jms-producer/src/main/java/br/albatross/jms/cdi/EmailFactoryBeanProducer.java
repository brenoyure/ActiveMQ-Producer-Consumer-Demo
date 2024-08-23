package br.albatross.jms.cdi;

import br.albatross.apis.email.factory.EmailFactoryBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;

public class EmailFactoryBeanProducer {

    @Produces
    @RequestScoped
    public EmailFactoryBean createFactoryBean() {
        return new EmailFactoryBean();
    }

}
