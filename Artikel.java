/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;

public class Artikel {
    private String plaats;
    private int grootte;
    private int artikelnr;

    public Artikel(int artikelnr, String plaats, int grootte) {
        this.plaats = plaats;
        this.grootte = grootte;
        this.artikelnr = artikelnr;
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




}
