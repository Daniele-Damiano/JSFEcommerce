/**
 *
 * @author Daniele Damiano
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jms.consumatore;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Produttore {

    
      public static void main(String[] args) {
        
          try {
             Dati dati = new Dati("Messaggio dal Produttore", 22);
              Context context  = new InitialContext();
              ConnectionFactory con = (ConnectionFactory)context.lookup("jms/ConnectionFactory1");
              Destination topic = (Destination)context.lookup("jms/Topic");
              
              try(JMSContext jmsContext = con.createContext()){
                  jmsContext.createProducer().send(topic, dati);
                   
              }
          } catch (NamingException ex) {
              Logger.getLogger(Produttore.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
}
