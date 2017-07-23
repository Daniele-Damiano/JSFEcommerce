/**
 *
 * @author Daniele Damiano
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.datasourceejbconinterfaccialocaleERemota;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Startup
@DataSourceDefinition(
        name = "java:global/jdbc/BookDS",
        className = "org.apache.derby.jdbc.ClientDatasource40",
        portNumber = 1527,
        user = "app",
        password = "app",
        properties = {"connectionAttributes =;create=true"},
        databaseName = "DataSourceEjbConInterfacciaLocale"
)
public class InizializzazioneDatabaseStartup {

   @Inject
   private IcomandiImpl impl;

    private Book b;

    @PostConstruct
    public void createBook(Book b) {
        b = new Book("La Divina COmmedia", "Libro di dante alighieri", 12);
        impl.createBook(b);
    }

    

}
