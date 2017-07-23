/**
 *
 * @author Daniele Damiano 
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.datasourceejbconinterfaccialocaleERemota;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface IcomandiRemote {
    void createBook(Book b);
    List<Book> FindAll();
}
