/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import Entitys.Libro;
import Entitys.editorial;
import javax.ejb.Local;

/**
 *
 * @author astrid
 */
@Local
public interface TransLocal {
    
    public void crearReg(Libro libro,editorial editor);
    public void crearRegNew(Libro libro,editorial editor);
    public void crearSup(Libro libro,editorial editor) ;
    public void crearSupNot(Libro libro,editorial editor);
    public void crearNever(Libro libro,editorial editor);
    public void crearMan(Libro libro,editorial editor);
}

