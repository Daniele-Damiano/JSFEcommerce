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

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


public class ProduttoreLogger {
    
    @Produces
    public Logger creaLogger(InjectionPoint ic) {
        return Logger.getLogger(ic.getMember().getDeclaringClass().getName());
    }
}
