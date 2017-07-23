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
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(
        name = "java:global/jdbc/BookDS",
        className = "org.apache.derby.jdbc.ClientDataSource40",
        user = "app",
        password ="app",
        databaseName ="DataSourceEjbConInterfacciaLocale",
        properties = {"connectionAttributes=;create=true"}
)
public class StartUpDatabase {
    
    @Inject
    private IcomandiImpl impl;
    
    private Book b1;
    private Book b2;
    
    @PostConstruct
    public void createBook(){
        b1 = new Book("La Divina Commedia", "Libro Scritto Da dante alighieri", 20);
        b2 = new Book("JavaEE7", "Libro di programmazione Java", 35);        
        
        impl.createBook(b1);
        impl.createBook(b2);
    }
    
    
}
