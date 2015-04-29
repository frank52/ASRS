package ASRS;

/**
 * Created by Maarten on 29-4-2015.
 */
public class Logboek {
    private int ordernr;
    private int aantalPakketten;
    private int aantalArtikkelen;
    private Klant klant;
    private String datum;

    public Logboek(int ordernr, int aantalPakketten, int aantalArtikkelen, Klant klant, String datum) {
        this.ordernr = ordernr;
        this.aantalPakketten = aantalPakketten;
        this.aantalArtikkelen = aantalArtikkelen;
        this.klant = klant;
        this.datum = datum;
    }


    public int getOrdernr() {
        return ordernr;
    }

    public int getAantalPakketten() {
        return aantalPakketten;
    }

    public int getAantalArtikkelen() {
        return aantalArtikkelen;
    }

    public Klant getKlant() {
        return klant;
    }

    public String getDatum() {
        return datum;
    }
}
