/**
 *
 * @author Daniele Damiano 
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame.damianodanielejpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Viaggio implements Serializable{
    @Id
    private String Id;
    private String genere;
    private String destinazione;
    private int prezzo;
    private String data;

    public Viaggio() {}

    
    public Viaggio(String Id, String genere, String destinazione, int prezzo, String data) {
        this.Id = Id;
        this.genere = genere;
        this.destinazione = destinazione;
        this.prezzo = prezzo;
        this.data = data;
    }

    public String getId() {
        return Id;
    }

    public String getGenere() {
        return genere;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public String getData() {
        return data;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
