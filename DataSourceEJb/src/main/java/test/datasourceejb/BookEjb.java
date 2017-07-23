/**
 *
 * @author Daniele Damiano
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.datasourceejb;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Singleton
@Startup
@DataSourceDefinition(
        name = "java:global/jdbc/BookDS",
        className = "org.apache.derby.jdbc.ClientDataSource40",
        user = "APP",
        password = "APP",
        databaseName = "BookDatabase",
        portNumber = 1527
)
public class BookEjb {

    @Inject
    private EntityManager em;

    private Book book1;

    @PostConstruct
    public void createBook() {
        book1 = new Book("Dante", "Selva");
        em.persist(book1);
    }
    

}
