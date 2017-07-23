/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.datasourceejbconinterfaccialocaleERemota;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@Remote
@Local
@LocalBean
@Interceptors(InterceptorClass.class)
public class IcomandiImpl implements Icomandi, IcomandiRemote {

    @Inject
    private EntityManager em;

    public void createBook(Book b) {
        em.persist(b);
    }
    
    
    public List<Book> FindAll() {
        TypedQuery<Book> retrive = em.createNamedQuery("findAll", Book.class);
        return retrive.getResultList();
    }

}
