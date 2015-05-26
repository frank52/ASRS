package ASRS;

import java.util.ArrayList;

public class SimpelGretig
{

    private Scherm scherm;
    private ArrayList<Integer> resultaten;
    private ArrayList<Artikel> artikellijst;
    private ArrayList<Pakket> actievePakketten;
    private ArrayList<Pakket> vollePakketten;
    private ArrayList<ArrayList<String>> actiePerArtikel;
    private int pakketTeller = 1;

    public SimpelGretig(ArrayList<Vak> vakken, Scherm scherm)
    {
        Database d1 = new Database();
        d1.SelectArtikel();
        ArrayList<Artikel> allArtikelen = d1.getlistArtikel();
        artikellijst = new ArrayList<>();

        for (Vak i : vakken)
        {
            for (Artikel a : allArtikelen)
            {
                if (i.getLocatie() == a.getPlaats())
                {
                    artikellijst.add(a);
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
        for (Artikel a : artikellijst)
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
