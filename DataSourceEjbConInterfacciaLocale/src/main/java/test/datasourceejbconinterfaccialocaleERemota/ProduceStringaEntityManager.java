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

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProduceStringaEntityManager {

    @Produces
    @PersistenceContext(unitName = "BookPU")
    private EntityManager em;
}
