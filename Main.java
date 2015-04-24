package ASRS;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) throws Exception {

        //Hoofdscherm openen
        Scherm scherm = new Scherm();
        scherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scherm.setVisible(true);

        // File Explorerer settings
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        ArrayList<Integer> artikelnrs = new ArrayList();
        artikelnrs.add(8);
        artikelnrs.add(4);
        artikelnrs.add(7);
        artikelnrs.add(6);
        artikelnrs.add(3);
        
        Klant klant = new Klant("Piet", " van Jansen", "Kalverstraat 17", "1012NX", "Amsterdam");
        
        Bestelling bestelling = new Bestelling(1231,"23-11-1996", artikelnrs, klant, 3);
        bestelling.generatePakbonnen();
        System.out.println("klaar");
        
    }

}
