/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;

public class Klant {
    private String voornaam;
    private String achternaam;
    private String address;
    private String woonplaats;
    private String postcode;

    public Klant(String voornaam, String achternaam, String address, String woonplaats, String postcode) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.address = address;
        this.woonplaats = woonplaats;
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    
    
}
