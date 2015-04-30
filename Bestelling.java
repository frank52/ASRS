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
    private ArrayList<Artikel> artikelen;


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
    
    public void convertIntToArtikel(ArrayList<Integer> artikelnrs) {
        Database d1 = new Database();
        d1.SelectArtikel();
        ArrayList<Artikel> allArtikelen = d1.getlistArtikel();
        artikelen = new ArrayList<>();
        System.out.println(allArtikelen);
        for (int i : artikelnrs) {
            //System.out.println(artikelen);
            //System.out.println(artikelnrs);
            //System.out.println(i);
            for (Artikel a : allArtikelen) {
                //System.out.println(a);
                if (i == a.getArtikelnr()) {
                    artikelen.add(a);
                }
            }
        }
        
    }


    public void generatePakbonnen() {
        System.out.println("test1");
        convertIntToArtikel(artikelnrs);
        System.out.println("test2");
        int i = 0;
        while (i < hoeveelheidPakketten) {
            i++;
            
            System.out.println(artikelen + "?");
            Pakbon pakbon = new Pakbon(orderNr, klant, artikelen, i, hoeveelheidPakketten);
            pakbon.maakPaklijstAlsTxt();
        }
    }
}
