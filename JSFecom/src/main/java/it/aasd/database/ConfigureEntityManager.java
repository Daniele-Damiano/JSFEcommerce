/**
 *
 * @author Daniele Damiano  26-lug-2017 20.46.50
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.aasd.database;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class ConfigureEntityManager {

   @Produces
   @PersistenceContext(unitName = "WebServicePU")
   private EntityManager em;
}
