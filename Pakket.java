/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;

import java.util.ArrayList;

public class Pakket
{
    private ArrayList<Artikel> artikelen;
    private int aantalArtikelen;

    // Stephan's insert
    private int nummerPakket;
    private int hoogte;
    private ArrayList<Artikel> inhoudPakket;
    /// einde Stephan's insert

    public Pakket(ArrayList<Artikel> artikelen, int aantalArtikelen)
    {
        this.artikelen = artikelen;
        this.aantalArtikelen = aantalArtikelen;
    }

    public Pakket()
    {
        inhoudPakket = new ArrayList<>();
        hoogte = 10;
    }

    public Pakket(int i)
    {
        this();
        nummerPakket = i;
    }

    public int getHoogte()
    {
        return hoogte;
    }

    public ArrayList<Artikel> getInhoudPakket()
    {
        return inhoudPakket;
    }

    public int getOvergeblevenHoogte()
    {
        int overgeblevenHoogte = hoogte;

        for (Artikel a : inhoudPakket)
        {
            overgeblevenHoogte = overgeblevenHoogte - a.getGrootte();
        }
        return overgeblevenHoogte;
    }

    public void voegArtikelToe(Artikel a)
    {
        inhoudPakket.add(a);

    }

    public int getNummer()
    {
        return nummerPakket;
    }

    public ArrayList<Artikel> getArtikelen()
    {
        return artikelen;
    }

    public int getAantalArtikelen()
    {
        return aantalArtikelen;
    }
}
