/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entitys.editorial;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author astrid
 */
@Local
public interface editorialFacadeLocal {

    void create(editorial editorial);

    void edit(editorial editorial);

    void remove(editorial editorial);

    editorial find(Object id);

    List<editorial> findAll();

    List<editorial> findRange(int[] range);

    int count();
    
}
