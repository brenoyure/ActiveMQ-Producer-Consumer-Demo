package br.albatross.jms.controllers;

import br.albatross.jms.MyJmsProducer;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloController {

    @Inject
    private MyJmsProducer jmsProducer;

    @GET
    public Response sayHello(
            @QueryParam("assunto") String assunto, 
            @QueryParam("message") String message) {

        jmsProducer.send(assunto, message);

        return Response.ok("{'assunto': '" + assunto + "', 'mensagem': '" + message + "' }").build();

    }

}
