package ASRS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Willem on 12-5-2015.
 */
public class Order {

    private ArrayList<Vak> vakken = new ArrayList<>();
    private ArrayList<Integer> artikelnrs;
    private ArrayList<Artikel> allArtikelen;
    private ArrayList<Artikel> artikellijst = new ArrayList<>();


    public Order(ArrayList<Integer> artikelnrs) {
        this.artikelnrs = artikelnrs;
    }

    public ArrayList<Vak> getVakken() {
        return vakken;
    }

    public void addVak()
    {
        Database d1 = new Database();
        d1.SelectArtikel();
        allArtikelen = d1.getlistArtikel();


        for (int i : artikelnrs)
        {
            for (Artikel a : allArtikelen)
            {
                if (i == a.getArtikelnr())
                {
                    artikellijst.add(a);
                }
            }
        }
        for(Artikel a : artikellijst) {
            final String str = a.getPlaats();
            final Pattern pattern = Pattern.compile("[\\,'\"]");
            final String[] result = pattern.split(str);

            int x = Integer.parseInt(result[0]);
            int y = Integer.parseInt(result[1]);
            Vak vak = new Vak(x,y);
            vakken.add(vak);
            System.out.println("vakken:");
            System.out.println(vakken);
        }
        }



    }

