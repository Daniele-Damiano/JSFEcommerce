/**
 *
 * @author Daniele Damiano
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magazzino;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Starter {

    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();
            ArchivioRemoto cd = (ArchivioRemoto)ctx.lookup("java:global/Magazzino-1.0/Bookimpl!magazzino.ArchivioRemoto");
           // Book b = new Book("Gesu", "Dio", "A", 100, 100, 100);
            //cd.createBook(b);
            
            
            cd.aggiornaGiacenza(100);
            
            List<Book> c = cd.findTitolo("paradiso");
            for (Book book : c) {
                System.out.println(book.getTitolo());
                System.out.println(book.getAutore());
                System.out.println(book.getGiacenza());
                System.out.println(book.getPrezzo());
            }
            
        } catch (Exception e) {
        }

    }

}
