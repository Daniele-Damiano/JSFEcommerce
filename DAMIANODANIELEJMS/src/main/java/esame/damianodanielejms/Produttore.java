/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame.damianodanielejms;

import esame.damianodanielejpa.Viaggio;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Daniele Damiano 
 */
public class Produttore {

    
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        ConnectionFactory conn = (ConnectionFactory)ctx.lookup("jms/PDEsameConnectionFactory");
        Destination topic = (Destination)ctx.lookup("jms/PDEsameTopic");
        
        try(JMSContext context = conn.createContext()){
            Viaggio vc = new Viaggio("2", "Avventura", "NewJork", 50, "20/06/2017");
            context.createProducer().send(topic, vc);
        }
            
        
    }

}
