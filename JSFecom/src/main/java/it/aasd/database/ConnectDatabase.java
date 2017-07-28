/**
 *
 * @author Daniele Damiano  26-lug-2017 20.24.26
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.aasd.database;

import it.entity.Cliente;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        databaseName = "ProvaWebService",
        name = "java:global/jdbc/WebServiceDS",
        user = "app",
        password = "app",
        properties = {"connectionAttributes=;create=true"})
public class ConnectDatabase {

    @Inject
    private EntityManager em;

    private Cliente c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;

    @PostConstruct
    private void init() {
        c1 = new Cliente("Daniele", "Damiano");
        c2 = new Cliente("Salvatore", "Damiano");
        c3 = new Cliente("Silvana", "Cercola");
        c4 = new Cliente("Teresa", "Di Lorenzo");
        c5 = new Cliente("Francesco", "Di Lorenzo");
        c6 = new Cliente("Maria", "Truvolo");
        c7 = new Cliente("Viktoryia", "Macri");
        c8 = new Cliente("Antonio", "Baldo");
        c9 = new Cliente("Luca", "De Cristofaro");
        c10 = new Cliente("Gabriella", "Di Marzo");

        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(c5);
        em.persist(c6);
        em.persist(c7);
        em.persist(c8);
        em.persist(c9);
        em.persist(c10);
    }

    @PreDestroy
    private void relase() {
        System.out.println("Entita Rimosse");
        em.remove(c1);
        em.remove(c2);
        em.remove(c3);
        em.remove(c4);
        em.remove(c5);
        em.remove(c6);
        em.remove(c7);
        em.remove(c8);
        em.remove(c9);
        em.remove(c10);
       
    }
}
