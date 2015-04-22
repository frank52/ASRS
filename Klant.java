/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;

public class Klant {
    private String voornaam;
    private String achternaam;
    private String adres;
    private String woonplaats;
    private String postcode;

    public Klant(String voornaam, String achternaam, String adres, String woonplaats, String postcode) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    @Override
    public String toString(){
        return "Voornaam: " +voornaam +" \nAchtenaam: " + achternaam+ "\nAdres: "+ adres + "\nPostcode: "+ postcode+"\nWoonplaats: "+ woonplaats;
    }
    
    
}
