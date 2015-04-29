package ASRS;

/**
 * Created by Maarten on 29-4-2015.
 */
public class Logboek {
    private int ordernr;
    private int aantalPakketten;
    private int aantalArtikkelen;
    private String voornaam;
    private String achternaam;
    private String datum;

    public Logboek(int ordernr, int aantalPakketten, int aantalArtikkelen, String voornaam, String achternaam, String datum) {
        this.ordernr = ordernr;
        this.aantalPakketten = aantalPakketten;
        this.aantalArtikkelen = aantalArtikkelen;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.datum = datum;
    }

    public Logboek(int ordernr, String voornaam, String achternaam, String datum) {
        this.ordernr = ordernr;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.datum = datum;
    }

    public Logboek(int aantalPakketten, int aantalArtikkelen) {
        this.aantalPakketten = aantalPakketten;
        this.aantalArtikkelen = aantalArtikkelen;
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

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getDatum() {
        return datum;
    }
}
