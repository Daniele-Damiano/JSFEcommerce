/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.datasourceejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Daniele Damiano
 */
@Entity
public class Book implements Serializable {

    

    @Id
    @GeneratedValue
    private Long id;
    private String titolo;
    private String Descrizioe;

    public Book() {
    }

    public Book(String titolo, String Descrizioe) {
        
        this.titolo = titolo;
        this.Descrizioe = Descrizioe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizioe() {
        return Descrizioe;
    }

    public void setDescrizioe(String Descrizioe) {
        this.Descrizioe = Descrizioe;
    }

}
