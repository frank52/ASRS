package ASRS;

import java.util.ArrayList;

/**
 * Created by Willem on 12-5-2015.
 */
public class Order {

    private ArrayList<Vak> vakken = new ArrayList<>();

    public ArrayList<Vak> getVakken() {
        return vakken;
    }

    public void addVak(Vak vak)
    {
        vakken.add(vak);
    }
}
