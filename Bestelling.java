package ASRS;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

public class Bestelling {
    private int ordernr;
    private Klant klant;
    private String datum;
    private ArrayList<String> artikelnrs;
    private int hoeveelheidPakketen;


    public Bestelling(int ordernr, String datum, ArrayList<String> artikelnrs, Klant klant) {
        this.ordernr = ordernr;
        this.datum = datum;
        this.artikelnrs = artikelnrs;
        this.klant = klant;
        this.hoeveelheidPakketen = artikelnrs.size();
    }

    public int getHoeveelheidPakketen() {
        return hoeveelheidPakketen;
    }

    public void setHoeveelheidPakketen(int hoeveelheidPakketen) {
        this.hoeveelheidPakketen = hoeveelheidPakketen;
    }

    @Override
   public String toString(){
       return "Ordernummer: "+ ordernr +"\nDatum:"+ datum+"\nartikelnummers"+artikelnrs+ "\nKlant: "+klant.toString();
   }

    public Klant getKlant() {
        return klant;
    }

    public int getOrdernr() {
        return ordernr;
    }

    public String getDatum() {
        return datum;
    }

    public ArrayList<String> getArtikelnrs() {
        return artikelnrs;
    
  
    }
}
