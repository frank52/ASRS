package ASRS;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Willem on 1-5-2015.
 */
public class TekenPanel extends JPanel{

    private int verhouding = 100; //100 bij 100
    private int xSelf = 20; //startpunt x
    private int ySelf = 20; //startpunt y
    private Vak[][] alleVakken;
    private Color myColor;

    public TekenPanel(){

    }

    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        setBackground(Color.WHITE);
        tekenMagazijn(g);
        generateVakken(5);
        kleurVakjes();
        tekenMagazijn(g);
        for(Artikel a : d1.getlistLocatie()) {
            System.out.println(a.getPlaats());
        }
    }

    public void tekenMagazijn(Graphics g) {
        for(int i1 = 0; i1 < 5; i1++) {
            for(int i = 0; i < 5; i++) {
                g.setColor(Color.black);
                g.drawRect(xSelf, ySelf, verhouding, verhouding);
                g.setColor(myColor);
                g.fillRect(xSelf+1, ySelf+1, verhouding-1, verhouding-1);
                xSelf = xSelf + verhouding;

            }
            xSelf =20;
            ySelf = ySelf + verhouding;
        }
        xSelf = 20;
        ySelf = 20;
    }

    private void generateVakken(int s)
    {
        int col=0;
        int row;

        alleVakken = new Vak[s][s];
        for (row = 0; row < alleVakken.length; row++) {
            for (col = 0; col < alleVakken[row].length; col++)
            {
                Vak myVak = new Vak(col, row);
                alleVakken[row][col] = myVak;
//                System.out.println(alleVakken[row][col].toString());
            }
        }
    }
    Locatie l1 = new Locatie(5,5);
    Database d1 =  new Database();

    public void kleurVakjes(){
        d1.SelectLocatie();
        for(Artikel a: d1.getlistLocatie()) {
            if (l1.toString().equals(a.getPlaats())) {
                myColor = Color.RED;
            } else {
                myColor = Color.white;
            }
        }
    }


}




