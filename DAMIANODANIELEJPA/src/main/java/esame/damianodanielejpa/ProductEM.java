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

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//Eliminato il Metodo Main
public class ProductEM {
    @Produces
    @PersistenceContext(unitName = "PU")
    private EntityManager em;
}
