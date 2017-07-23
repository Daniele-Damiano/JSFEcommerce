/**
 *
 * @author Daniele Damiano 
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame.damianodanielejpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Stateless
public class ViaggioImpl implements Iviaggio{

    @Inject
    private EntityManager em;
    
    @Override
    public List<Viaggio> findId(String id) {
        Query q = em.createQuery("SELECT v FROM Viaggio v where v.Id = :id");
        q.setParameter("id", id);
        List<Viaggio> v = q.getResultList();
        return v;
    }

    @Override
    public List<Viaggio> findDestinazione(String dest) {
        Query q = em.createQuery("SELECT v FROM Viaggio v where v.destinazione = :dest");
        q.setParameter("dest", dest);
        List<Viaggio> v = q.getResultList();
        return v;
    }

    @Override
    public List<Viaggio> findGenere(String gen) {
         Query q = em.createQuery("SELECT v FROM Viaggio v where v.genere = :gen");
        q.setParameter("gen", gen);
        List<Viaggio> v = q.getResultList();
        return v;
        
    }

    @Override
    public List<Viaggio> all() {
        Query q = em.createQuery("SELECT v FROM Viaggio v");
        List<Viaggio> v = q.getResultList();
        return v;
    }

    @Override
    public Viaggio createViaggio(Viaggio v) {
        em.persist(v);
        return null;
    }

    @Override
    //Modifica al posto di CreateQuery modificato in CreateNativeQuery e modificata la stringa sql
    public void aggiornaDB(int prezzo) {
        Query q = em.createNativeQuery("UPDATE Viaggio SET v.prezzo = :prezzo where :prezzo >0");
        q.setParameter("prezzo", prezzo);
        q.executeUpdate();
    }

    
   

}
