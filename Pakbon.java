package ASRS;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Pakbon {

    private int pakbonID;
    private Klant klant;
    private ArrayList<Integer> artikelnrs;

    public Pakbon(Klant klant, int pakbonID, ArrayList<Integer> artikelnr) {
        this.klant = klant;
        this.pakbonID = pakbonID;
        this.artikelnrs = artikelnr;
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
            File file = new File("C:\\random\\Paklijst " + getPakbonID() + ".txt");
            FileWriter write = new FileWriter(file, false);
            PrintWriter print = new PrintWriter(write);

            //print inhoud
            print.println("######################### Paklijst " + pakbonID + " #########################");
            print.println("Aan: " + klant.getVoornaam() + " " + klant.getAchternaam() + ", " + klant.getAdres() + ", " + klant.getPostcode() + " " + klant.getWoonplaats());
            print.println("");
            print.println("Inhoud Doos:");

            int iPlus1;
            for (int i = 0; i < artikelnrs.size(); i++) {
                iPlus1 = i + 1;
                print.println(iPlus1 + ". " + artikelnrs.get(i));
            }

            print.close();
        }
        catch (Exception e) {
            //niks
        }
    }
}
