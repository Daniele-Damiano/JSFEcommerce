/**
 *
 * @author Daniele Damiano 
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package magazzino;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book implements Serializable {
    @Id
    private String titolo;
    private String autore;
    private String scaffale;
    private int num_pagine;
    private int prezzo;
    private int giacenza;

    public Book() {
    }

    
    public Book(String titolo, String autore, String scaffale, int num_pagine, int prezzo, int giacenza) {
        this.titolo = titolo;
        this.autore = autore;
        this.scaffale = scaffale;
        this.num_pagine = num_pagine;
        this.prezzo = prezzo;
        this.giacenza = giacenza;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getScaffale() {
        return scaffale;
    }

    public int getNum_pagine() {
        return num_pagine;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public int getGiacenza() {
        return giacenza;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setScaffale(String scaffale) {
        this.scaffale = scaffale;
    }

    public void setNum_pagine(int num_pagine) {
        this.num_pagine = num_pagine;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public void setGiacenza(int giacenza) {
        this.giacenza = giacenza;
    }
    
    

}
