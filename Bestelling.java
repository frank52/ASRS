package ASRS;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

public class Bestelling {
    private int orderNr;
    private Klant klant;
    private String datum;
    private ArrayList<Integer> artikelnrs;
    private ArrayList<Pakket> pakketten;
    private int hoeveelheidPakketten;


    public Bestelling(int orderNr, String datum, ArrayList<Integer> artikelnrs, Klant klant, int hoeveelheidPakketten) {
        this.orderNr = orderNr;
        this.datum = datum;
        this.artikelnrs = artikelnrs;
        this.klant = klant;
        this.hoeveelheidPakketten = hoeveelheidPakketten;
    }

    public int getHoeveelheidPakketten() {
        return hoeveelheidPakketten;
    }

    public void setHoeveelheidPakketten(int hoeveelheidPakketten) {
        this.hoeveelheidPakketten = hoeveelheidPakketten;
    }

    @Override
   public String toString(){
       return "Ordernummer: "+ orderNr +"\nDatum:"+ datum+"\nartikelnummers"+artikelnrs+ "\nKlant: "+klant.toString();
   }

    public Klant getKlant() {
        return klant;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public String getDatum() {
        return datum;
    }

    public ArrayList<Integer> getArtikelnrs() {
        return artikelnrs;
    }

    public void setPakketten(ArrayList<Pakket> pakketten) {
        this.pakketten = pakketten;
    }
    
    
    
    public void generatePakbonnen() {
        int i = 0;
        while (i < hoeveelheidPakketten) {
            i++;
            Pakbon pakbon = new Pakbon(orderNr, klant, pakketten, i, hoeveelheidPakketten);
            pakbon.maakPaklijstAlsTxt();
        }
    }
}
