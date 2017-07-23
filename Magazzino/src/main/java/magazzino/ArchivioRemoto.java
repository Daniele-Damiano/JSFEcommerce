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
import javax.ejb.Remote;

@Remote
public interface ArchivioRemoto {
    void createBook(Book b);
    void aggiornaGiacenza(int giacenza);
    List<Book> findTitolo(String Titolo);
    List<Book> findAutore(String Autore);
    List<Book> findScaffale(String Scaffale);
    
}
