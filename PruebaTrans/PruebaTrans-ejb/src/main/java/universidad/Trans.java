/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import Entitys.Libro;
import Entitys.editorial;
import Interfaces.LibroFacadeLocal;
import Interfaces.editorialFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author astrid
 */
@Stateless

@TransactionManagement(TransactionManagementType.CONTAINER)
public class Trans implements TransLocal {
   
    @EJB
    private LibroFacadeLocal libroFacade;
    @EJB
    private  editorialFacadeLocal editorialfacade;
    // se crean los diferentes metodos que van enlazados para que sean transaccionales

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearReg(Libro libro,editorial editor) {
      libroFacade.create(libro);
      editorialfacade.create(editor);
    }
    
      @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void crearRegNew(Libro libro,editorial editor) {
    libroFacade.create(libro);
    editorialfacade.create(editor); 
    
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void crearMan(Libro libro,editorial editor) {
         libroFacade.create(libro);
        editorialfacade.create(editor); 
     
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public void crearSup(Libro libro,editorial editor) {
       libroFacade.create(libro);
       editorialfacade.create(editor);
    }
    
    
      @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void crearSupNot(Libro libro,editorial editor) {
       
         libroFacade.create(libro);
         editorialfacade.create(editor);
  
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void crearNever(Libro libro,editorial editor) {
       libroFacade.create(libro);
       editorialfacade.create(editor);
    }
}
