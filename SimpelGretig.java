package ASRS;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SimpelGretig
{

    private Scherm scherm;
    private ArrayList<Integer> resultaten;
    private ArrayList<Artikel> artikellijst;
    private ArrayList<Pakket> actievePakketten;
    private ArrayList<Pakket> vollePakketten;
    private ArrayList<ArrayList<String>> actiePerArtikel;
    private ArrayList<Artikel> artikeli;
    private ArrayList<ArrayList<Artikel>> artikeli2 = new ArrayList<>();
    private ArrayList<Artikel> artikeli3 = new ArrayList<>();
    private Artikel tijdelijkArtikel;
    private int ii;
    private int pakketTeller = 1;

    public SimpelGretig(ArrayList<Vak> vakken, Scherm scherm)
    {
        Database d1 = new Database();
        d1.SelectArtikel();
        ArrayList<Artikel> allArtikelen = d1.getlistArtikel();
        artikellijst = new ArrayList<>();


        for (Vak i : vakken) //vakken naar artikelen
        {
            for (Artikel a1 : allArtikelen)
            {

                if (i.getLocatie().equals(a1.getPlaats()))
                {
                    artikellijst.add(a1);
                }
            }
        }
        artikeli = new ArrayList<>();
        for (Artikel i : artikellijst) //array splitsen naar 3
        {

            artikeli.add(i);

            ii++;
            if (ii == 3 || i.equals(artikellijst.get(artikellijst.size()-1))) {
                artikeli2.add(artikeli);
                ii = 0;

                artikeli = new ArrayList<>();
            }

        }
        for (ArrayList<Artikel> a : artikeli2)
        {

                while(a.size() > 0){
                try {
                    int size = a.size();
                    tijdelijkArtikel = a.get(size - 1);
                    artikeli3.add(tijdelijkArtikel);
                    a.remove(size - 1);


                }
                catch(IndexOutOfBoundsException e)
                {

                }
            }
        }


        actievePakketten = new ArrayList<>();
        vollePakketten = new ArrayList<>();
        actiePerArtikel = new ArrayList<>();

        this.scherm = scherm;

        // Twee nieuwe pakketten maken
        actievePakketten.add(new Pakket(pakketTeller));
        pakketTeller++;
        actievePakketten.add(new Pakket(pakketTeller));

    }

    public void vul()
    {
        ArrayList<String> actiesVanDitArtikel;
        for (Artikel a : artikeli3)
        {
            actiesVanDitArtikel = new ArrayList<>();

            if (actievePakketten.get(0).getOvergeblevenHoogte() >= a.getGrootte())
            {
                // Wanneer artikel in de linker container past -> plaatsen
                actievePakketten.get(0).voegArtikelToe(a);
                actiesVanDitArtikel.add("naarLinks");

            }
            else
            {
                if (actievePakketten.get(1).getOvergeblevenHoogte() >= a.getGrootte())
                {
                    actievePakketten.get(1).voegArtikelToe(a);
                    actiesVanDitArtikel.add("naarRechts");
                }
                else
                {
                    int overgeblevenRuimteEen = actievePakketten.get(0).getOvergeblevenHoogte();
                    int overgeblevenRuimteTwee = actievePakketten.get(1).getOvergeblevenHoogte();

                    if (overgeblevenRuimteEen < overgeblevenRuimteTwee)
                    {
                        vollePakketten.add(actievePakketten.get(0));
                        pakketTeller++;
                        actievePakketten.set(0, new Pakket(pakketTeller));

                        actiesVanDitArtikel.add("nieuwLinks");
                    }
                    else
                    {
                        vollePakketten.add(actievePakketten.get(1));
                        pakketTeller++;
                        actievePakketten.set(1, new Pakket(pakketTeller));

                        actiesVanDitArtikel.add("nieuwRechts");
                    }

                    if (actievePakketten.get(0).getOvergeblevenHoogte() >= a.getGrootte())
                    {
                        actievePakketten.get(0).voegArtikelToe(a);
                        actiesVanDitArtikel.add("naarLinks");
                    }
                    else if (actievePakketten.get(1).getOvergeblevenHoogte() >= a.getGrootte())
                    {
                        actievePakketten.get(1).voegArtikelToe(a);
                        actiesVanDitArtikel.add("naarRechts");
                    }
                }

            }
            actiePerArtikel.add(actiesVanDitArtikel);
        }
    }

    public ArrayList<ArrayList<String>> getActiePerArtikel()
    {
        return actiePerArtikel;
    }

    public ArrayList<Pakket> getActievePakketten()
    {
        return actievePakketten;
    }

    public ArrayList<Pakket> getVollePakketten()
    {
        return vollePakketten;
    }

    public ArrayList<Pakket> getAllePakketten()
    {
        ArrayList<Pakket> allePakketten = new ArrayList<>();
        allePakketten.addAll(vollePakketten);
        allePakketten.addAll(actievePakketten);
        return allePakketten;
    }
}
