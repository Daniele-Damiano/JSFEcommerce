/**
 *
 * @author Daniele Damiano  26-lug-2017 20.24.26
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.database;

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
        System.out.println("INIZIO CREAZIONE CLIENTI");
        c1 = new Cliente("Daniele", "Damiano","danieledamiano@gmail.com","danieledamiano");
        c2 = new Cliente("Salvatore", "Damiano","salvatoredamiano@gmail.com","salvatoredamiano");
        c3 = new Cliente("Silvana", "Cercola","silvanacercola@gmail.com","silvanacercola");
        c4 = new Cliente("Teresa", "Di Lorenzo","teresadilorenzo@gmail.com","teresadilorenzo");
        c5 = new Cliente("Francesco", "Di Lorenzo","francescodilorenzo@gmail.com","francescodilorenzo");
        c6 = new Cliente("Maria", "Truvolo","mariatruvolo@gmail.com","mariatruvolo");
        c7 = new Cliente("Viktoryia", "Macri","viktoryiamacri@gmail.com","viktoryiamacri");
        c8 = new Cliente("Antonio", "Baldo","antoniobaldo@gmail.com","antoniobaldo");
        c9 = new Cliente("Luca", "De Cristofaro","lucadecristofaro@gmail.com","lucadecristofaro");
        c10 = new Cliente("Gabriella", "Di Marzo","gabrielladimarzo@gmail.com","gabrielladimarzo");
       
        System.out.println("CLIENTI CREATI");
        
        System.out.println("INIZIO PERSIST NEL DASTABSE");
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
       
        System.out.println("PERSIST COMPLETATO");
    }

    @PreDestroy
    private void relase() {
        System.out.println("INIZIO RIMOZIONE ENTITà");
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
        System.out.println("RIMOSSE TUTTE LE ENTITà");
    }
}
