package ASRS;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Pakbon {

    private int pakbonID;
    private Klant klant;
    private ArrayList<Integer> artikelnrs;
    private int pakketnr;
    private int hoeveelheidPakketen;

    public Pakbon(int pakbonID, Klant klant, ArrayList<Integer> artikelnrs, int pakketnr, int hoeveelheidPakketen) {
        this.pakbonID = pakbonID;
        this.klant = klant;
        this.artikelnrs = artikelnrs;
        this.pakketnr = pakketnr;
        this.hoeveelheidPakketen = hoeveelheidPakketen;
    }

    public Pakbon() {

    }

    public Klant getKlant() {
        return klant;
    }

    public int getPakbonID() {
        return pakbonID;
    }

    public ArrayList<Integer> getArtikelnr() {
        return artikelnrs;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public void setPakbonID(int pakbonID) {
        this.pakbonID = pakbonID;
    }

    public void setArtikelnr(ArrayList<Integer> artikelnr) {
        this.artikelnrs = artikelnr;
    }

    public void generatePakbon() {
        try {
                File file = new File("Paklijst " + getPakbonID() + "van 5.txt");
                FileWriter write = new FileWriter(file, false);
                PrintWriter print = new PrintWriter(write);

                //print inhoud
                print.println("######################### Paklijst " + pakbonID + " #########################");
                print.println("Aan: " + klant.getVoornaam() + " " + klant.getAchternaam() + ", " + klant.getAdres() + ", " + klant.getPostcode() + " " + klant.getWoonplaats());
                print.println("");
                print.println("Inhoud Pakket:");

                int iPlus1;
                for (int i = 0; i < artikelnrs.size(); i++) {
                    iPlus1 = i + 1;
                    print.println("Artikel " +  ": " + artikelnrs.get(i));
                }

            print.close();
        }
        catch (Exception e) {
            //niks
        }
    }
}
