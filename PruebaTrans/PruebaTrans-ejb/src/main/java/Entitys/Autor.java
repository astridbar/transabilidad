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
@Table(name = "autor")
public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    @Column 
    private String Autor;

    /**
     *se crea un contructor unicamente con la variable autor
     * @param Autor
     */
    public Autor(String Autor) {
        this.Autor = Autor;
    }
    
    /**
     *se crea un contructor vacio
     */
    public Autor() {
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
    public String getAutor() {
        return Autor;
    }

    /**
     *metodo set 
     * @param Autor
     */
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }
    
     
}