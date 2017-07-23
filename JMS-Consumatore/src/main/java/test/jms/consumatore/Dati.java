/**
 *
 * @author Daniele Damiano
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jms.consumatore;

import java.io.Serializable;

public class Dati implements Serializable {

    private static final long serialVersionUID = 1L;
    private String unaStringa;
    private int unIntero;

    public Dati(String unaStringa, int unIntero) {
        this.unaStringa = unaStringa;
        this.unIntero = unIntero;
    }

    public String getUnaStringa() {
        return unaStringa;
    }

    public void setUnaStringa(String unaStringa) {
        this.unaStringa = unaStringa;
    }

    public int getUnIntero() {
        return unIntero;
    }

    public void setUnIntero(int unIntero) {
        this.unIntero = unIntero;
    }

}
