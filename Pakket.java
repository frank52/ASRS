/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;

import java.util.ArrayList;

public class Pakket {
    private ArrayList<Artikel> artikelen;
    private int aantalArtikelen;

    public Pakket(ArrayList<Artikel> artikelen, int aantalArtikelen) {
        this.artikelen = artikelen;
        this.aantalArtikelen = aantalArtikelen;
    }
    
    public ArrayList<Artikel> getArtikelen() {
        return artikelen;
    }

    public int getAantalArtikelen() {
        return aantalArtikelen;
    }
}
