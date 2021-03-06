package ASRS;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Willem on 1-5-2015.
 */
public class TekenPanel extends JPanel
{
    ArrayList<Artikel> artikelen;

    private int verhouding = 100; //100 bij 100
    private int xSelf = 20; //startpunt x
    private int ySelf = 20; //startpunt y

    private Scherm scherm;
    private ArrayList<Vak> vakken;
    private ArrayList<Integer> xArray;
    private ArrayList<Integer> yArray;
    private ArrayList<String> locatie1 = new ArrayList<>();
    private boolean returnBoolean2;
    private int index;
    private ArduinoFuncties arduinoFuncties;
    Database d1 = new Database();



    public TekenPanel(Scherm scherm, ArrayList<Vak> vakken)
    {

        this.scherm=scherm;
        d1.SelectLocatie();
        d1.SelectArtikel();
        ArrayList<Integer> artikelnrs = scherm.getArtikel();
        ArrayList<Artikel> allArtikelen = d1.getlistArtikel();
        artikelen = new ArrayList<>();
        this.vakken = vakken;
        for (int i : artikelnrs) {
            //System.out.println(i);
            for (Artikel a : allArtikelen) {
                //System.out.println(a);
                if (i == a.getArtikelnr()) {
                    Artikel artikel = new Artikel(a.getPlaats());
                    artikelen.add(artikel);
                }
            }
        }

    }

    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        setBackground(Color.WHITE);

        tekenMagazijn(g);


    }

    public void tekenMagazijn(Graphics g)
    {

        ArrayList<Artikel> artikelen = d1.getlistLocatie();

        for (int i1 = 0; i1 < 5; i1++)
        {
            for (int i = 0; i < 5; i++)
            {
                String locatie = "" + i + "," + i1 + "";
                locatie1.add(locatie);

                g.setColor(Color.black);
                g.drawRect(xSelf, ySelf, verhouding, verhouding);

                if (checkOvereenkomst(locatie))
                {
                    g.setColor(Color.RED);
                    if(!routeLocatie(locatie))
                    {
                        g.setColor(Color.GREEN);
                    }

                }
                else
                {
                    g.setColor(Color.WHITE);
                }

                g.fillRect(xSelf + 1, ySelf + 1, verhouding - 1, verhouding - 1);
                if(routeLocatie(locatie))
                {
                    g.setFont(new Font("SanSerif", Font.BOLD, 26));
                    g.setColor(Color.BLACK);
                    g.drawString("" + index + "", xSelf+43, ySelf+58);

                }
                xSelf = xSelf + verhouding;

            }
            xSelf = 20;
            ySelf = ySelf + verhouding;
        }
        xSelf = 20;
        ySelf = 20;
        repaint();
    }

    public boolean checkOvereenkomst(String s)
    {
        boolean returnBoolean;
        returnBoolean = false;

        ArrayList<Artikel> artikelLijst = artikelen;

        for (Artikel a : artikelLijst)
        {

            if (a.getPlaats().equals(s))
            {
                returnBoolean = true;
            }

        }
        return returnBoolean;
    }
    public boolean routeLocatie(String s)
    {
        boolean returnBoolean2;
        returnBoolean2 = false;
        int i = 1;
            for (Vak v : vakken) {

                if (v.getLocatie().equals(s)) {
                    index = i;
                    returnBoolean2 = true;
                }
                i++;
            }
        //System.out.println(vakken);
        //System.out.println(artikelen);
        return returnBoolean2;

    }


}
