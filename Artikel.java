/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;

public class Artikel {
    private String plaats;
    private int grootte;

    public Artikel(String plaats, int grootte) {
        this.plaats = plaats;
        this.grootte = grootte;
    }

    public String getPlaats() {
        return plaats;
    }

    public int getGrootte() {
        return grootte;
    }
    
    
}
