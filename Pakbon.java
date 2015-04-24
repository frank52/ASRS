package ASRS;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Pakbon {

    private int orderNr;
    private Klant klant;
    private ArrayList<Pakket> pakketten;
    private int pakketnr;
    private int totaalHoeveelheidPakketten;
    

    public Pakbon(int orderNr, Klant klant, ArrayList<Pakket> pakketten, int pakketnr, int totaalHoeveelheidPakketten) {
        this.orderNr = orderNr;
        this.klant = klant;
        this.pakketten = pakketten;
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

    public ArrayList<Pakket> getArtikelnr() {
        return pakketten;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public void setArtikelnr(ArrayList<Pakket> artikelnr) {
        this.pakketten = pakketten;
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
                for (int i = 0; i < pakketten.size(); i++) {
                    iPlus1 = i + 1;
                    print.println("Artikel " +  ": " + pakketten.get(i));
                    
                }

            print.close();
        }
        catch (Exception e) {
            //niks
        }
    }
}
