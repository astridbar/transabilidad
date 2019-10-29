/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import Entitys.Autor;
import Entitys.Libro;
import Entitys.editorial;
import Interfaces.AutorFacadeLocal;
import Interfaces.LibroFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author astrid
 * 
 */
@Stateless

@TransactionManagement(TransactionManagementType.CONTAINER)
public class Transaccion implements TransaccionLocal {
   @EJB
    private AutorFacadeLocal autorfacade;

    @EJB
    private LibroFacadeLocal librofaceda;
    
    @EJB
    universidad.Trans transaccionLocal;

// se crena los metodos no transacionales
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearReq(Autor autor , Libro libro) {
        librofaceda.create(libro);
        autorfacade.create(autor);

    }
  @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void crearReqNew(Autor autor , Libro libro) {
     librofaceda.create(libro);
     autorfacade.create(autor);

    }
    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void crearmand(Autor autor , Libro libro) {
       librofaceda.create(libro);
        autorfacade.create(autor);

    }@Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public void crearSupor(Autor autor , Libro libro) {
       librofaceda.create(libro);
        autorfacade.create(autor);


    }

  @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void crearSupNot(Autor autor , Libro libro) {
       librofaceda.create(libro);
       autorfacade.create(autor);

    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void crearNever(Autor autor , Libro libro) {
     librofaceda.create(libro);
     autorfacade.create(autor);

    }


    
    //se crean los metodos transaccioneles Metodos transaccionales
    
    // se crea el metodo transacional requieres con requieres
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearTransaccionalR(Autor autor , Libro libro,editorial editorial) {
        autorfacade.create(autor);
        transaccionLocal.crearReg(libro, editorial);
    }
    
      // se crea el metodo transacional requieres con requieres new
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearTransaccionalRN(Autor autor , Libro libro,editorial editorial) {
        autorfacade.create(autor);
        try{
         transaccionLocal.crearRegNew(libro, editorial);
        }
        catch(Exception e){
        }
        
    }
    
    
          // se crea el metodo transacional requieres con mandatory 

     @Override
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearTransaccionalM(Autor autor , Libro libro,editorial editorial) {
        autorfacade.create(autor);
        transaccionLocal.crearMan(libro, editorial);
    }
    
          // se crea el metodo transacional requieres con support 

     @Override
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearTransaccionalS(Autor autor , Libro libro,editorial editorial) {
        autorfacade.create(autor);
        transaccionLocal.crearSup(libro, editorial);
    }
    
      // se crea el metodo transacional requieres con not support
    
     @Override
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearTransaccionalSN(Autor autor , Libro libro,editorial editorial) {
        autorfacade.create(autor);
        try{
        transaccionLocal.crearSupNot(libro, editorial);
        }
        catch(Exception e){
        }
        
    }
          // se crea el metodo transacional requieres con never
    

     @Override
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearTransaccionalN(Autor autor , Libro libro,editorial editorial) {
        autorfacade.create(autor);
        
        try{
        transaccionLocal.crearNever(libro, editorial);
        }
        catch(Exception e){
        }
    }   
    
}
