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
        
        
        
        //pakbon testen
        ArrayList<Artikel> artikels= new ArrayList();
        ArrayList<Pakket> pakketten= new ArrayList();
        
        //meerdere pakketten maken
        for (int ii = 0; ii < 3; ii++) {
            //meerdere artikels maken
            for (int i = 0 ; i < 3 ; i++) {
            Artikel artikel = new Artikel("A1", i + 5);
            artikels.add(artikel);
            }
            
            Pakket pakket = new Pakket(artikels, artikels.size());
            pakketten.add(pakket);
        }
        
        ArrayList<Integer> artikeltjes = new ArrayList();
        
        Klant klant = new Klant("Piet", " van Jansen", "Kalverstraat 17", "1012NX", "Amsterdam");
        
        Bestelling bestelling = new Bestelling(1231,"23-11-1996", artikeltjes, klant, 3);
        bestelling.setPakketten(pakketten);
        bestelling.generatePakbonnen();


        Database d1 = new Database();
       // d1.DatabaseBestelling();

        d1.Select();
    }

}
