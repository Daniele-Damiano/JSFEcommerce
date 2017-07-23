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

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name ="findAll", query = "select c from Book c")
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private String titolo;
    private String descrizione;
    private int prezzo;

    public Book() {
    }

    public Book(String titolo, String descrizione, int prezzo) {
        this.titolo = titolo;
        this.prezzo = prezzo;
        this.descrizione = descrizione;

    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

}
