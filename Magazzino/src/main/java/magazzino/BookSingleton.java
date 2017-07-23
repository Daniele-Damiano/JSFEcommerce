/**
 *
 * @author Daniele Damiano 
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package magazzino;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.ClientDataSource40",
        name = "jdbc/PDESAMEDS",
        user = "app",
        password = "app",
        databaseName = "BookDB",
        properties = {"connectionAttributes=;create=true"}
)
public class BookSingleton {
    @Inject
    private Bookimpl im;
    
    @PostConstruct
    private void create(){
        Book b = new Book("paradiso", "dante", "A", 800, 29, 50);
        Book b1 = new Book("inferno", "dante", "B", 200, 5, 10);
        im.createBook(b);
        im.createBook(b1);
    }
}
