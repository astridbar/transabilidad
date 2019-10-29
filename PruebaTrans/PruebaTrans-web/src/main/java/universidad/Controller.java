/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import Entitys.Autor;
import Entitys.Libro;
import Entitys.editorial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
public class Controller implements Serializable{
    // se crean las variables y se instancian los ejb
    private String autor;
    private String libro;
    private String editorial;
    @EJB
     TransaccionLocal transaccion;

    /**
     *  se crea el constructor vacio 
     */
    public Controller() {
    }


    Autor autores;
    private List<Autor> listaA;

    Libro libros;
    private List<Libro> listaL;
    
    editorial editoril;
    private List<editorial> listaE;

    /**
     *
     */
    @PostConstruct
    public void init (){
        listaA=new ArrayList<>();
        listaL=new ArrayList<>();
        listaE=new ArrayList<>();
    }
   
// METODOS NO TRANSACCIONALES 

    /**
     *se crea el metodo agregar para el metodo de transaccion requieres
     * es te metodo es no transacccional 
     */
        public void request() {
         // entra le metodo y crea los dos objetos entitys   
        Autor auto = new Autor(autor);
        Libro lib = new Libro(libro);
        // los en via al metodo de transaccion
        transaccion.crearReq(auto, lib);
        System.out.println("no se agrego la transaccion");
        FacesMessage msg = new FacesMessage("No se realizo la transaccion.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    
    }
    
    /**
     *se crea el metodo agregar para el metodo de transaccion requieres new
     * este metodo es no transacccional 
     */
    public void requestnew() {
        Autor auto = new Autor(autor);
        Libro lib = new Libro(libro);
        transaccion.crearReqNew(auto, lib);
        
        System.out.println("no se agrego la transaccion");
        FacesMessage msg = new FacesMessage("No se realizo la transaccion.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }

     /**
     *se crea el metodo agregar para el metodo de transaccion support 
     * este metodo es no transacccional 
     */
    public void supports() {
        Autor auto = new Autor(autor);
        Libro lib = new Libro(libro);
        transaccion.crearSupor(auto, lib);
        
        System.out.println("no se agrego la transaccion");
        FacesMessage msg = new FacesMessage("No se realizo la transaccion.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

     /**
     *se crea el metodo agregar para el metodo de transaccion mandatory
     * este metodo es no transacccional 
     */
    public void mandatory() {
        Autor auto = new Autor(autor);
        Libro lib = new Libro(libro);
        transaccion.crearmand(auto, lib);
        
        System.out.println("no se agrego la transaccion");
        FacesMessage msg = new FacesMessage("No se realizo la transaccion.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

     /**
     *se crea el metodo agregar para el metodo de transaccion not support
     * este metodo es no transacccional 
     */
    public void notsupport() {
        Autor auto = new Autor(autor);
        Libro lib = new Libro(libro);
        transaccion.crearSupNot(auto, lib);
        System.out.println("no se agrego la transaccion");
        FacesMessage msg = new FacesMessage("No se realizo la transaccion.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     *se crea el metodo agregar para el metodo de transaccion never
     * este metodo es no transacccional 
     */
    public void never() {
         Autor auto = new Autor(autor);
        Libro lib = new Libro(libro);
        transaccion.crearNever(auto, lib);
        
        System.out.println("no se agrego la transaccion");
        FacesMessage msg = new FacesMessage("No se realizo la transaccion.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //METODOS TRANSACCIONALES

    /**
     *se crea el metodo agregar transacional requires
     */
        public void agregarTransReq() {
        //entra al metodo y crea los 3  objetos entitys
        Autor auto = new Autor(autor);
        Libro lib = new Libro(libro);
        editorial edit = new editorial(editorial);
        transaccion.crearTransaccionalR(auto,lib,edit);
        //son envíados al metodo en transaccional
        transaccion.crearTransaccionalR(auto, libros, null);
        System.out.println("agrego");
        FacesMessage msg = new FacesMessage(" Transaccional realizada con Requires .");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     *se crea el metodo agregar transacional requires new
     */
    public void agregarTransReqNew() {
        Autor auto = new Autor(autor);
        Libro lib = new Libro(libro);
        editorial edit = new editorial(editorial);
        transaccion.crearTransaccionalRN(auto,lib,edit);
        System.out.println("agrego");
        FacesMessage msg = new FacesMessage(" Transaccional realaizada con Requires new .");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /**
     *se crea el metodo agregar transacional support
     */
    public void agregarTransSup() {
        Autor auto = new Autor(autor);
        Libro lib = new Libro(libro);
        editorial edit = new editorial(editorial);
        transaccion.crearTransaccionalS(auto,lib,edit);
        System.out.println("agrego");
        
        FacesMessage msg = new FacesMessage(" Transaccional realizada con support .");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /**
     *se crea el metodo agregar transacional mandatory
     */
    public void agregarTransMand() {
        Autor auto = new Autor(autor);
        Libro lib = new Libro(libro);
        editorial edit = new editorial(editorial);
        transaccion.crearTransaccionalM(auto,lib,edit);
        System.out.println("agrego");
        
        FacesMessage msg = new FacesMessage(" Transaccional realizada con mandatory .");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /**
     *se crea el metodo agregar transacional not support
     */
    public void agregarTransNotSup() {
    Autor auto = new Autor(autor);
    Libro lib = new Libro(libro);
    editorial edit = new editorial(editorial);
    transaccion.crearTransaccionalSN(auto, lib, edit);
    System.out.println("agrego");
     FacesMessage msg = new FacesMessage(" Transaccional realizada con not support.");
    FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /**
     *se crea el metodo agregar transacional never
     */
    public void agregarTransNever() {
       Autor auto = new Autor(autor);
        Libro lib = new Libro(libro);
        editorial edit = new editorial(editorial);
        transaccion.crearTransaccionalN(auto,lib,edit);
        System.out.println("agrego");
        
        FacesMessage msg = new FacesMessage(" Transaccional realizada con never .");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     *metodo get
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     *metodo set
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     *metodo get
     * @return
     */
    public String getLibro() {
        return libro;
    }

    /**
     *metodo set
     * @param libro
     */
    public void setLibro(String libro) {
        this.libro = libro;
    }

    /**
     *metodo get
     * @return
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     *metodo set
     * @param editorial
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     *metodo get
     * @return
     */
    public TransaccionLocal getTransaccion() {
        return transaccion;
    }

    /**
     *metodo set
     * @param transaccion
     */
    public void setTransaccion(TransaccionLocal transaccion) {
        this.transaccion = transaccion;
    }

    /**
     *metodo get
     * @return
     */
    public Autor getAutores() {
        return autores;
    }

    /**
     *metodo set
     * @param autores
     */
    public void setAutores(Autor autores) {
        this.autores = autores;
    }

    /**
     *metodo get
     * @return
     */
    public List<Autor> getListaA() {
        return listaA;
    }

    /**
     *metodo set
     * @param listaA
     */
    public void setListaA(List<Autor> listaA) {
        this.listaA = listaA;
    }

    /**
     *metodo get
     * @return
     */
    public Libro getLibros() {
        return libros;
    }

    /**
     *metodo set
     * @param libros
     */
    public void setLibros(Libro libros) {
        this.libros = libros;
    }

    /**
     *metodo get
     * @return
     */
    public List<Libro> getListaL() {
        return listaL;
    }

    /**
     *metodo set
     * @param listaL
     */
    public void setListaL(List<Libro> listaL) {
        this.listaL = listaL;
    }

    /**
     *metodo get
     * @return
     */
    public editorial getEditoril() {
        return editoril;
    }

    /**
     *metodo set
     * @param editoril
     */
    public void setEditoril(editorial editoril) {
        this.editoril = editoril;
    }

    /**
     *metodo get
     * @return
     */
    public List<editorial> getListaE() {
        return listaE;
    }

    /**
     *metodo set
     * @param listaE
     */
    public void setListaE(List<editorial> listaE) {
        this.listaE = listaE;
    }

    
    
    
}