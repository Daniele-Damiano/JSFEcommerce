/**
 *
 * @author Daniele Damiano
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jms.produttore;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Consumatore {

    public static void main(String[] args) {
        try {
            Context context = new InitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(("jms/ConnectionFactory1"));
            Destination topic = (Destination) context.lookup("jms/Topic");

            try (JMSContext jmsContext = connectionFactory.createContext()) {
                while (true) {
                    Dati mess = jmsContext.createConsumer(topic).receiveBody(Dati.class);
                    System.out.println("Messaggio ricevuto"+" "+mess);
                   
                }
            }
        } catch (NamingException ex) {
            Logger.getLogger(Consumatore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
