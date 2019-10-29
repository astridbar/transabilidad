/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author astrid
 */
@Entity
@Table(name="editorial")
public class editorial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int  id;
    @Column
     private String nombre;

    /**
     *se crea un constructor vacio con la variable nombre
     * @param nombre
     */
    public editorial( String nombre) {
        this.nombre = nombre;
    }

    // se crea un constructor vacio
    public editorial() {
    }
    
    
    
    /**
     *metodo get
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *metodo set
     * @param id
     */
    public void setId(int id) {
        this.id = id;
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

  
    
    
}
