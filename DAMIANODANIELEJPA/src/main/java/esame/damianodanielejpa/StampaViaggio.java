/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame.damianodanielejpa;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Daniele Damiano 
 */
public class StampaViaggio {

    
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        Iviaggio v =(Iviaggio)ctx.lookup("java:global/DAMIANODANIELEJPA-1.0/ViaggioImpl!esame.damianodanielejpa.Iviaggio");
        List<Viaggio>cd = v.all();
        for(Viaggio vi :cd){
            System.out.println(vi.getId());
            System.out.println(vi.getPrezzo());
            System.out.println(vi.getGenere());
            System.out.println(vi.getDestinazione());
            System.out.println(vi.getData());
        }
        
    }

}
