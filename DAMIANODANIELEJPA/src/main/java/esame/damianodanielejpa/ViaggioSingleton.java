/**
 *
 * @author Daniele Damiano
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame.damianodanielejpa;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.jdbc.derby.ClientDataSource40",
        name = "jdbc/PDEsameDS",
        databaseName = "TravelDB",
        user = "app",
        password = "app",
        properties = {"connectionAttributes=;create=true"})
public class ViaggioSingleton {
    @Inject
    private ViaggioImpl im;
    
    @PostConstruct
    public void createViaggio(){
        Viaggio c = new Viaggio("1", "Divertimento", "Sydney", 40, "19/12/2017");
        im.createViaggio(c);
        
    }
}
