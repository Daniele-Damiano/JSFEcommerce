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

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StarterInterfacciaRemota {

    public StarterInterfacciaRemota() {
    }

    public static void main(String[] args) throws NamingException {

        Context c = new InitialContext();
        IcomandiRemote cd = (IcomandiRemote) c.lookup("java:global/DataSourceEjbConInterfacciaLocaleERemota-1.0/IcomandiImpl!test.datasourceejbconinterfaccialocaleERemota.IcomandiRemote");
       // cd.createBook(new Book("Wiko", "iggy", 11));
        List<Book> find = cd.FindAll();
        for (Book book : find) {
            System.out.println("Titolo = " + " " + book.getTitolo());
            System.out.println("Descrizione = " + " " + book.getDescrizione());
            System.out.println("Prezzo = " + " " + book.getPrezzo());
            System.out.println("-----------------------------------------------------------");
        }

    }

}
