package ASRS;

import java.util.ArrayList;

/**
 * Created by Willem on 12-5-2015.
 */
public class Route {

    private ArrayList<Vak> volgorde;

    private int afstand;

    public Route(ArrayList<Vak> volgorde,int afstand) {
        this.volgorde = volgorde;
        this.afstand = afstand;
    }

    public ArrayList<Vak> getVolgorde() {
        return volgorde;
    }

    public int getAfstand() {
        return afstand;
    }
}
