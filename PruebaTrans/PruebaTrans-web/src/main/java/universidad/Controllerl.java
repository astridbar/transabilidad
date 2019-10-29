/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import datos.datos;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author astrid
 */
@Named
@RequestScoped
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Controllerl {
    private String nombre;
    private String apellido;
    private  int edad;  

    /**
     *se crea el metodo no tansaccional pero desde la parte logica para ver que si entra 
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearR(){
        datos datos =new datos(nombre,apellido,edad);
        datos.setNombre(nombre);
        datos.setApellido(apellido);
        datos.setEdad(edad);        
        FacesMessage msg = new FacesMessage("metodo transaccional required");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("agrego");  
    }
    
    /**
     *
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
        public void crearRN(){
        datos datos =new datos(nombre,apellido,edad);
        datos.setNombre(nombre);
        datos.setApellido(apellido);
        datos.setEdad(edad); 
        FacesMessage msg = new FacesMessage("metodo transaccional requieres new");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("agrego"); 
        }
        
    /**
     *
     */
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
        public void crearS(){
        datos datos =new datos(nombre,apellido,edad);
        datos.setNombre(nombre);
        datos.setApellido(apellido);
        datos.setEdad(edad); 
        FacesMessage msg = new FacesMessage("metodo transaccional support");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("agrego");   
    }
    
    /**
     *
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
        public void crearSP(){
        datos datos =new datos(nombre,apellido,edad);
        datos.setNombre(nombre);
        datos.setApellido(apellido);
        datos.setEdad(edad);        
       FacesMessage msg = new FacesMessage("metodo transaccional not support");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("agrego");  
    }
        
    /**
     *
     */
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
            public void crearM(){
        datos datos =new datos(nombre,apellido,edad);
        datos.setNombre(nombre);
        datos.setApellido(apellido);
        datos.setEdad(edad);
        
        FacesMessage msg = new FacesMessage("metodo transaccional mandatory");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("agrego");   
    }
    
    /**
     *
     */
    @TransactionAttribute(TransactionAttributeType.NEVER)        
    public void crearN(){
        try{
        datos datos =new datos(nombre,apellido,edad);
        datos.setNombre(nombre);
        datos.setApellido(apellido);
        datos.setEdad(edad);
        FacesMessage msg = new FacesMessage("metodo transaccional never");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("agrego");
        
        }catch(Exception e){
        
        }  
    }
    
    /**
     *metodo get
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *metodo set
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *metodo get
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *metodo set
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *metodo get
     * @return
     */
    public int getEdad() {
        return edad;
    }

    /**
     *metodo set
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    

}
