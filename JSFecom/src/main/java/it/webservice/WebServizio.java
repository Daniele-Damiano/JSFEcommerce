/**
 *
 * @author Daniele Damiano  26-lug-2017 20.17.29
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.webservice;

import it.entity.Cliente;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/mostracliente")
@Produces(MediaType.APPLICATION_XML)
public class WebServizio {

    private Cliente cliente;
    
    @Inject
    private EntityManager em;

//    @GET
//    public List<Cliente> getClientes() {
//        System.out.println("Entrato in getClientes");
//        Query query = em.createNamedQuery("allClient");
//        List<Cliente> c = query.getResultList();
//        return c;
//    }

    @GET
    @Path("login/{email}/{password}")
    @Produces(MediaType.APPLICATION_XML)
    public Cliente login(@PathParam("email") String email, @PathParam("password") String password) {
        Query query = em.createNamedQuery("login");
        query.setParameter("email", email);
        query.setParameter("password", password);
        try {
            this.cliente = (Cliente) query.getSingleResult();
            return cliente;
        } catch (NoResultException e) {
            return null;
        }
    }
        
    

    @POST
    @Path("insertCliente")
    @Consumes(MediaType.TEXT_PLAIN)
    public void insertCliente() {
        System.out.println("Entrato in insertCliente()");

    }

}
