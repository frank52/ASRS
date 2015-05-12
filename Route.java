package ASRS;

import java.util.ArrayList;

/**
 * Created by Willem on 12-5-2015.
 */
public class Route {

    private ArrayList<Vak> volgorde;

    private int afstand;

    public Route(ArrayList<Vak> volgorde) {
        this.volgorde = volgorde;
    }

    public int berekenAfstand(ArrayList<Vak> volgorde) {
        int afstand;
        afstand = volgorde.size() * Vak.getGroote();

        return afstand;
    }
}
