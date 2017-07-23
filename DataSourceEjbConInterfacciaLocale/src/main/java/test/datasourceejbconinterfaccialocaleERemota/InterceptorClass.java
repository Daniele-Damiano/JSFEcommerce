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
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


public class InterceptorClass {
    @Inject
    private Logger log;
    
    @AroundInvoke
    public Object log(InvocationContext ic)throws Exception {
        log.info("----------------------Sono Entarto");
        log.info(ic.getClass().getName());
        log.info(ic.getMethod().getName());
        return ic.proceed();
    }
}
