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
@Table(name = "libros")
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    @Column
    private String libro;

    /**
     *se crea un contructor unicamente con la variable libro
     * @param libro
     */
    public Libro(String libro) {
        this.libro = libro;
    }

    /**
     *se crea un constructor vacio
     */
    public Libro() {
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
    
}
