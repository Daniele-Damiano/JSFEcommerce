/**
 *
 * @author Daniele Damiano 
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mag.magazzinojms;


public class Messaggio {
    private String titolo;
    private String numero;

    public Messaggio(String titolo, String numero) {
        this.titolo = titolo;
        this.numero = numero;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getNumero() {
        return numero;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}
