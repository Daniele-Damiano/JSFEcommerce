/**
 *
 * @author Daniele Damiano  27-lug-2017 12.10.42
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.beanweb;

import it.entity.Cliente;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

@Named
@RequestScoped
public class ControllerServlet {

    List<Cliente> cli;
    private Client client;
    private final String URI = "http://localhost:8080/JSFecom/rs";

    @PostConstruct
    private void init() {
        client = ClientBuilder.newClient();
    }

    @PreDestroy
    private void relase() {
        client.close();
    }

    public String navigazionaPagine() {
        System.out.println("Entrato navigazionaPagine()");
        String navigation;
        cli = client.target(URI).path("/mostracliente").request().get(new GenericType<List<Cliente>>() {});// new GenericType costruisce Lisy<Cliente> un costruttore vuoto 
        if (cli == null) {
            navigation = "error";
        } else {
            navigation = "success";
        }
        return navigation;
    }
    
    public List<Cliente> getCli() {
        return cli;
    }

    public void setCli(List<Cliente> cli) {
        this.cli = cli;
    }

   
    

}
