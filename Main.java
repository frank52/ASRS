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
                        Klant klant = new Klant("Piet", " van Jansen", "Kalverstraat 17", "1012NX", "Amsterdam");
                        ArrayList<Integer> artikelnrs = new ArrayList();
                        artikelnrs.add(3);
                        artikelnrs.add(5);
                        artikelnrs.add(8);
                        artikelnrs.add(1);
                        artikelnrs.add(2);
                        System.out.println(artikelnrs);
                        Pakbon pakbon = new Pakbon(klant, 3, artikelnrs);
                        pakbon.generatePakbon();
    }

}
