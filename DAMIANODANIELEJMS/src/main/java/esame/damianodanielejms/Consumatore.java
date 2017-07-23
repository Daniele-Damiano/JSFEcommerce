/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame.damianodanielejms;

import esame.damianodanielejpa.Iviaggio;
import esame.damianodanielejpa.Viaggio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Daniele Damiano 
 */
public class Consumatore implements MessageListener{

    //Dichiarata variabile vi statica
    private static Iviaggio vi;
    
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        vi = (Iviaggio)ctx.lookup("java:global/DAMIANODANIELEJPA-1.0/ViaggioImpl!esame.damianodanielejpa.Iviaggio");
        ConnectionFactory conn = (ConnectionFactory)ctx.lookup("jms/PDEsameConnectionFactory");
        Destination topic = (Destination)ctx.lookup("jms/PDEsameTopic");
        
        try(JMSContext context = conn.createContext()){
            context.createConsumer(topic).setMessageListener(new Consumatore());
        }
    }

    @Override
    public void onMessage(Message m) {
        try {
            
            Viaggio v = m.getBody(Viaggio.class);
            vi.aggiornaDB(v.getPrezzo());
            
        } catch (JMSException ex) {
            Logger.getLogger(Consumatore.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

}
