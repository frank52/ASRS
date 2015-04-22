package ASRS;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maarten K
 */
public class Pakbon {
    private Klant klant;
    private String productNaam;
    private int paklijst;
    private int artikelnr;

    public Pakbon(Klant klant, String productNaam, int paklijst, int artikelnr) {
        this.klant = klant;
        this.productNaam = productNaam;
        this.paklijst = paklijst;
        this.artikelnr = artikelnr;
    }

    
    
    public Klant getKlant() {
        return klant;
    }

    public String getProductNaam() {
        return productNaam;
    }

    public int getPaklijst() {
        return paklijst;
    }

    public int getArtikelnr() {
        return artikelnr;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public void setPaklijst(int paklijst) {
        this.paklijst = paklijst;
    }

    public void setArtikelnr(int artikelnr) {
        this.artikelnr = artikelnr;
    }
    
    
    
}
