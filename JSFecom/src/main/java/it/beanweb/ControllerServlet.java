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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

@Named
@RequestScoped
public class ControllerServlet {

    private Cliente cliente;
    private List<Cliente> cli;
    private Client client;
    private final String URI = "http://localhost:8080/JSFecom/rs";
    private final String URI1 = "http://localhost:8080/JSFecom/rs/mostracliente/login/";

     
     @PostConstruct
    private void init() {
        client = ClientBuilder.newClient();
        cliente = new Cliente();
        cli = new ArrayList<>();
    }

    @PreDestroy
    private void relase() {
        client.close();
    }

//    public String callGetClientes() {
//        System.out.println("Entrato navigazionaPagine()");
//        String navigation;
//
//        cli = client.target(URI).path("/mostracliente").request().get(new GenericType<List<Cliente>>() {
//        });// new GenericType costruisce Lisy<Cliente> un costruttore vuoto 
//
//        if (cli == null) {
//            navigation = "error";
//        } else {
//            navigation = "success";
//        }
//        return navigation;
//    }

    public String callLogin() {
        System.out.println("ENTRATO IN CALLLOGIN()");
        String navigation = "ClientFound";
        FacesContext faces = FacesContext.getCurrentInstance();

        if (cliente.getEmail().equalsIgnoreCase("")) {
            System.out.println("IL CAMPO EMAIL E NULL");
            faces.addMessage("loginform:email", new FacesMessage(FacesMessage.SEVERITY_WARN, "Email Obbligatoria", "Inserisci Email"));
            return null;
        }
        if (cliente.getPassword().equalsIgnoreCase("")) {
            System.out.println("IL CAMPO PASSWORD E NULL");
            faces.addMessage("loginform:password", new FacesMessage(FacesMessage.SEVERITY_WARN, "Password Obbligatoria", "Inserisci Password"));
            return null;
        }
        /**
         * Navigazione Fra pagine
         */
        if (cliente.getEmail().equalsIgnoreCase("admin") && cliente.getPassword().equalsIgnoreCase("admin")) {
            System.out.println("TRUE");
            navigation = "adminPage";
            return navigation;
        }
        /**
         * Se non la login non e ugual ad admin allora e un cliente e cerca
         * chiamando il servizio login nella classe WebServizio il cliente in
         * base all'email e la password inserita nel form login
         */
        
        cliente = client.target(URI1).path(cliente.getEmail()).path(cliente.getPassword()).request().get(Cliente.class);
        if(cliente == null){
            
            return "ClientNotFound";
        }
            

        System.out.println("INVOCAZIONE CLIENTBUILDER OK");
        cli.add(cliente);//viene inserito nell arraylist per la durata della sessione
        System.out.println("CLIENTE AGGIUNTO");
       
         return navigation;
    }

    
    
    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getCli() {
        return cli;
    }

    public void setCli(List<Cliente> cli) {
        this.cli = cli;
    }

}
