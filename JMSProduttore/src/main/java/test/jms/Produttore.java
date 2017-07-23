/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jms;

import java.util.Date;
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
        Context context = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) context.lookup("jms/ConnectionFacotry");
        Destination queue = (Destination) context.lookup("jms/Queue");
        try (JMSContext jmsc = cf.createContext()) {
            jmsc.createProducer().send(queue, "Perche");

        }
    }

}
