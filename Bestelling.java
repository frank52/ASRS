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

    @Override
   public String toString(){
       return "Ordernummer: "+ orderNr +"\nDatum:"+ datum+"\nartikelnummers"+artikelnrs+ "\npakketten"+pakketten + hoeveelheidPakketten + "\nKlant:----- \n"+klant.toString();
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
    
    public void setHoeveelheidPakketten(int hoeveelheidPakketten) {
        this.hoeveelheidPakketten = hoeveelheidPakketten;
    }
    
    
    
    public void generatePakbonnen() {
        
        // hardcoded test
        ArrayList<Artikel> artikels = new ArrayList();
        ArrayList<Pakket> pakketten1 = new ArrayList();
        
        //meerdere pakketten maken
        for (int ii = 0; ii < 3; ii++) {
            //meerdere artikels maken
            for (int i = 0 ; i < 3 ; i++) {
            Artikel artikel = new Artikel("A1", i + 5);
            artikels.add(artikel);
            }
            
            Pakket pakket = new Pakket(artikels, artikels.size());
            pakketten1.add(pakket);
        }
        
        
        
        setPakketten(pakketten1);
        System.out.println(pakketten1);
        System.out.println(hoeveelheidPakketten);
        
        
        
        int i = 0;
        while (i < hoeveelheidPakketten) {
            i++;
            Pakbon pakbon = new Pakbon(orderNr, klant, pakketten, i, hoeveelheidPakketten);
            pakbon.maakPaklijstAlsTxt();
        }
    }
}
