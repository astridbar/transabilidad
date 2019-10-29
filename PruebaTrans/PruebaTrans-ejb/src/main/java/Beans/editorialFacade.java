/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entitys.editorial;
import Interfaces.AbstractFacade;
import Interfaces.editorialFacadeLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author astrid
 */
@Stateless
public class editorialFacade extends AbstractFacade<editorial> implements editorialFacadeLocal {
    @PersistenceContext(unitName = "universidad_PruebaTrans-ejb_ejb_1.0.10-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public editorialFacade() {
        super(editorial.class);
    }
    
}
