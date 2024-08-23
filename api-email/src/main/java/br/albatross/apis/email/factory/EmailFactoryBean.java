package br.albatross.apis.email.factory;

import br.albatross.apis.email.Email;
import br.albatross.apis.email.EmailDadosDoEnvioImpl;
import br.albatross.apis.email.EmailImpl;

public class EmailFactoryBean {

    public static Email newInstance() {
        return new EmailImpl(new EmailDadosDoEnvioImpl());
    }

}
