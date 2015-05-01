/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;

import java.util.ArrayList;

public class Artikel {

    private String plaats;
    private int grootte;
    private int artikelnr;
    private int aantalArt;
    private String naam;

    public Artikel(int artikelnr, String plaats, int grootte, int aantalArt, String naam) {
        this.plaats = plaats;
        this.grootte = grootte;
        this.artikelnr = artikelnr;
        this.aantalArt = aantalArt;
        this.naam=naam;
    }

    public Artikel(String plaats, int grootte, int artikelnr, String naam) {
        this.plaats = plaats;
        this.grootte = grootte;
        this.artikelnr = artikelnr;
        this.naam = naam;
    }
    public Artikel(String plaats){
        this.plaats=plaats;
    }

    @Override
    public String toString() {
        return "Artikel{" + "plaats=" + plaats + ", grootte=" + grootte + ", artikelnr=" + artikelnr + ", aantalArt=" + aantalArt + ", naam=" + naam + '}';
    }

    

    public int getAantalArt() {
        return aantalArt;
    }

    public String getPlaats() {
        return plaats;
    }

    public int getGrootte() {
        return grootte;
    }

    public int getArtikelnr() {
        return artikelnr;
    }

    public String getNaam() {
        return naam;
    }
}
