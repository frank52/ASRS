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
    int i1;
    int i;
    String locatie1;

    public TekenPanel(){

    }

    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        setBackground(Color.WHITE);

        tekenMagazijn(g);
        kleurVakjes();
        tekenMagazijn(g);


//        for(Artikel a : d1.getlistLocatie()) {
//            System.out.println(a.getPlaats());
//        }

    }

    public void tekenMagazijn(Graphics g){
        for( i1= 0; i1 < 5; i1++) {
            for(i = 0; i < 5; i++) {
                g.setColor(Color.black);
                g.drawRect(xSelf, ySelf, verhouding, verhouding);
                g.setColor(myColor);
                g.fillRect(xSelf + 1, ySelf + 1, verhouding - 1, verhouding - 1);
                xSelf = xSelf + verhouding;
                String locatie= "("+i1+","+i+")";
                locatie1=locatie;

            }
            xSelf =20;
            ySelf = ySelf + verhouding;
        }
        xSelf = 20;
        ySelf = 20;
    }

    Database d1 =  new Database();

    public void kleurVakjes(){
        d1.SelectLocatie();
        for(Artikel a: d1.getlistLocatie()) {
            if (locatie1.equals(a.getPlaats())) {
                myColor = Color.RED;
            } else {
                myColor = Color.white;
            }
        }
    }


}




