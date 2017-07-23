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
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


@Stateless
@LocalBean
public class Bookimpl implements ArchivioRemoto{
    @Inject
    private EntityManager em;

    @Override
    public void createBook(Book b) {
       em.persist(b);
    }

    @Override
    public void aggiornaGiacenza(int giacenza) {
       Query q = em.createNativeQuery("UPDATE Book b set b.giacenza = :giacenza where b.giacenza >0", Book.class);
       q.setParameter("giacenza", giacenza);
       
    }

    @Override
    public List<Book> findTitolo(String titolo) {
        Query q = em.createQuery("Select c from Book c where c.titolo = :titolo");
        q.setParameter("titolo", titolo);
        List<Book> b = q.getResultList();
        return b;
    }

    @Override
    public List<Book> findAutore(String autore) {
        Query q = em.createQuery("Select c from Book c where c.autore = :autore");
        q.setParameter("autore", autore);
        List<Book> b = q.getResultList();
        return null;
    }

    @Override
    public List<Book> findScaffale(String scaffale) {
         Query q = em.createQuery("Select c from Book c where c.scaffale = :scaffale");
        q.setParameter("scaffale", scaffale);
        List<Book> b = q.getResultList();
        return null;
    }
    
    
}
