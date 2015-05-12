package ASRS;

import java.util.ArrayList;

public class Bestelling
{
    private int orderNr;
    private Klant klant;
    private String datum;
    private ArrayList<Integer> artikelnrs; //voor bpp
    private ArrayList<Pakket> pakketten;
    private int hoeveelheidPakketten;
    private ArrayList<Artikel> artikelen;

    public Bestelling(int orderNr, String datum, ArrayList<Integer> artikelnrs, Klant klant)
    {
        this.orderNr = orderNr;
        this.datum = datum;
        this.artikelnrs = artikelnrs;
        this.klant = klant;
    }

    public int getHoeveelheidPakketten()
    {
        return hoeveelheidPakketten;
    }

    @Override
    public String toString()
    {
        return "Ordernummer: " + orderNr + "\nDatum:" + datum + "\nartikelnummers" + artikelnrs + "\npakketten" + pakketten + hoeveelheidPakketten + "\nKlant:----- \n" + klant.toString();
    }

    public Klant getKlant()
    {
        return klant;
    }

    public int getOrderNr()
    {
        return orderNr;
    }

    public String getDatum()
    {
        return datum;
    }

    public ArrayList<Integer> getArtikelnrs()
    {
        return artikelnrs;
    }

    public void setPakketten(ArrayList<Pakket> pakketten)
    {
        this.pakketten = pakketten;
        this.hoeveelheidPakketten = pakketten.size();
        
    }

    public void generatePakbonnen()
    {
        int i = 0;
        while (i < hoeveelheidPakketten)
        {
            artikelen = pakketten.get(i).getInhoudPakket();
            i++;
            Pakbon pakbon = new Pakbon(orderNr, klant, artikelen, i, hoeveelheidPakketten);
            pakbon.maakPaklijstAlsTxt();
        }
    }
}
