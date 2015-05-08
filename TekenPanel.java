package ASRS;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Willem on 1-5-2015.
 */
public class TekenPanel extends JPanel
{

    private int verhouding = 100; //100 bij 100
    private int xSelf = 20; //startpunt x
    private int ySelf = 20; //startpunt y
    private Color myColor;

    private ArrayList<String> locatie1 = new ArrayList<>();
    Database d1 = new Database();

    public TekenPanel()
    {
        d1.SelectLocatie();
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
                String locatie = "(" + i1 + "," + i + ")";
                locatie1.add(locatie);

                g.setColor(Color.black);
                g.drawRect(xSelf, ySelf, verhouding, verhouding);

                if (tekenVakjes(locatie))
                {
                    g.setColor(Color.RED);
                }
                else
                {
                    g.setColor(Color.WHITE);
                }

                g.fillRect(xSelf + 1, ySelf + 1, verhouding - 1, verhouding - 1);
                xSelf = xSelf + verhouding;

            }
            xSelf = 20;
            ySelf = ySelf + verhouding;
        }
        xSelf = 20;
        ySelf = 20;
    }

    public boolean tekenVakjes(String s)
    {
        boolean returnBoolean;
        returnBoolean = false;

        ArrayList<Artikel> artikelLijst = d1.getlistLocatie();

        for (Artikel a : artikelLijst)
        {

            if (a.getPlaats().equals(s))
            {
                returnBoolean = true;
                
            }

        }
        return returnBoolean;
    }

}
