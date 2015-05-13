package ASRS;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Pakbon {

    private int orderNr;
    private Klant klant;
    private ArrayList<Artikel> artikelnrs;
    private int pakketnr;
    private int totaalHoeveelheidPakketten;
    

    public Pakbon(int orderNr, Klant klant, ArrayList<Artikel> artikelnrs, int pakketnr, int totaalHoeveelheidPakketten) {
        this.orderNr = orderNr;
        this.klant = klant;
        this.artikelnrs = artikelnrs;
        this.pakketnr = pakketnr;
        this.totaalHoeveelheidPakketten = totaalHoeveelheidPakketten;
    }

    public Pakbon() {

    }

    public Klant getKlant() {
        return klant;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public ArrayList<Artikel> getArtikelnrs() {
        return artikelnrs;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public void setArtikelnr(ArrayList<Artikel> artikelnrs) {
        this.artikelnrs = artikelnrs;
    }

    public void maakPaklijstAlsTxt() {
        try {
                
                
                File file = new File("Paklijst " + pakketnr + " van " + totaalHoeveelheidPakketten + " (" + orderNr + ")" + ".txt");
                FileWriter write = new FileWriter(file, false);
                PrintWriter print = new PrintWriter(write);

                //print inhoud
                print.println("################# Order: " + orderNr + " #########" + " Paklijst " + pakketnr + "/" + totaalHoeveelheidPakketten + " #################");
                print.println("");
                print.println("Aan: " + klant.getVoornaam() + " " + klant.getAchternaam() + ", " + klant.getAdres() + ", " + klant.getPostcode() + " " + klant.getWoonplaats());
                print.println("");
                print.println("Inhoud Pakket:");

                int iPlus1;
                for (int i = 0; i < artikelnrs.size(); i++) {
                    iPlus1 = i + 1;
                    print.println("Artikel " +  ": " + artikelnrs.get(i).getNaam());
                    print.println("grootte: " + artikelnrs.get(i).getGrootte());
                    
                }

            print.close();
        }
        catch (Exception e) {
            //niks
        }
    }
}
