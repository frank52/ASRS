package ASRS;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;


public class Bestelling {
    private int ordernr;
    private Date datum;
    private int artikelnr;
    private Klant klant;

    public Bestelling(int ordernr, Date datum, int artikelnr, Klant klant) {
        this.ordernr = ordernr;
        this.datum = datum;
        this.artikelnr = artikelnr;
        this.klant = klant;
    }

   

    public Klant getKlant() {
        return klant;
    }

    public int getOrdernr() {
        return ordernr;
    }

    public Date getDatum() {
        return datum;
    }

    public int getArtikelnr() {
        return artikelnr;
    
  
    }
}
