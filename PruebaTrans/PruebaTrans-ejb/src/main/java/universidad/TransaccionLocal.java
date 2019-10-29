/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import Entitys.Autor;
import Entitys.Libro;
import Entitys.editorial;
import javax.ejb.Local;

/**
 *
 * @author astrid
 */
@Local
public interface TransaccionLocal {
    // no transaccionales
    public void crearReq(Autor autor , Libro libro);
    public void crearReqNew(Autor autor , Libro libro);
    public void crearmand(Autor autor , Libro libro);
    public void crearSupor(Autor autor , Libro libro);
    public void crearSupNot(Autor autor , Libro libro);
    public void crearNever(Autor autor , Libro libro);
    
    
    //transaccionales
    
    public  void crearTransaccionalR(Autor autor , Libro libro,editorial editorial);
    public  void crearTransaccionalRN(Autor autor , Libro libro,editorial editorial);
    public  void crearTransaccionalM(Autor autor , Libro libro,editorial editorial);
    public  void crearTransaccionalS(Autor autor , Libro libro,editorial editorial);
    public  void crearTransaccionalSN(Autor autor , Libro libro,editorial editorial);
    public  void crearTransaccionalN(Autor autor , Libro libro,editorial editorial);
    
}


