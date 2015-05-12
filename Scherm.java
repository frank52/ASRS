package ASRS;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.ExportException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

@SuppressWarnings("serial")
public class Scherm extends JFrame implements ActionListener
{

    private JButton selecteerXML;
    private JButton stopSysteem;
    private JButton startSysteem;
    private JButton genereerPakbon;
    private JTabbedPane jTabbedPane1;
    private JTable table1;
    private JScrollPane jScrollPane1;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private DefaultTableModel model4;
    private DefaultTableModel model5;
    private DefaultTableModel model6;
    JPanel p6 = new JPanel();
    int ii = 0;
    private Calendar cal;
    private ArrayList<Bestelling> bestellingen;
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    private final JFileChooser jfc;
    private boolean nietsselect = false;
    private ArrayList<Artikel> artikelen;
    private ArrayList<Integer> artikelnrs;

    public Scherm()
    {

        this.jfc = new JFileChooser();
        this.jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        this.jfc.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));

        //Hoofdscherm settings
        setTitle("AS/RS controle systeem");
        setLayout(new BorderLayout());
        setSize(1280, 720);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //buttons
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        Dimension panelD = new Dimension(231, 100);
        p1.setPreferredSize(panelD);
        add(p1, BorderLayout.WEST);
        selecteerXML = new JButton("Selecteer XML-order");
        selecteerXML.setPreferredSize(new Dimension(200, 40));
        p1.add(selecteerXML, BorderLayout.WEST);
        selecteerXML.addActionListener(this);
        stopSysteem = new JButton("Stop systeem");
        stopSysteem.setPreferredSize(new Dimension(200, 40));
        stopSysteem.setVisible(false);
        p1.add(stopSysteem, BorderLayout.WEST);
        stopSysteem.addActionListener(this);
        startSysteem = new JButton("Start systeem");
        startSysteem.setPreferredSize(new Dimension(200, 40));
        p1.add(startSysteem, BorderLayout.WEST);
        startSysteem.addActionListener(this);

        //tabbladen
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        JPanel p5 = new JPanel();
        p5.setLayout(new GridLayout(0, 10));
        JLabel geplandeOrders = new JLabel("Geplande Orders");
        p5.add(geplandeOrders);
        JLabel niks = new JLabel("");
        p5.add(niks);
        JLabel huidgeOrder = new JLabel("Huidige Order");
        p5.add(huidgeOrder);
        p2.add(p5, BorderLayout.NORTH);
        model = new DefaultTableModel();
        table1 = new JTable(model);
        model.addColumn("Ordernummer");
        model.addColumn("Huidig Artikel");
        model.addColumn("Benodigde Artikelen");
        model.addColumn("Klant");
        table1.setEnabled(false);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.getTableHeader().setResizingAllowed(false);

        model6 = new DefaultTableModel();
        JTable table2 = new JTable(model6);
        model6.addColumn("Ordernummer");
        table2.setEnabled(false);
        table2.getTableHeader().setReorderingAllowed(false);
        table2.getTableHeader().setResizingAllowed(false);

        JScrollPane jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(table2);
        jScrollPane2.setPreferredSize(new Dimension(150, 700));

        jScrollPane1 = new JScrollPane();
        jScrollPane1.setPreferredSize(new Dimension(880, 700));

        jScrollPane1.setViewportView(table1);

        p2.add(jScrollPane1, BorderLayout.EAST);
        p2.add(jScrollPane2, BorderLayout.WEST);

        JPanel p3 = new JPanel();

        p3.setLayout(
                new GridLayout(0, 1));
        model2 = new DefaultTableModel();
        table1 = new JTable(model2);

        model2.addColumn("Bericht");
        model2.addColumn("Type bericht");
        model2.addColumn("Tijd");
        table1.setEnabled(false);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.getTableHeader().setResizingAllowed(false);

        jScrollPane1 = new JScrollPane();

        jScrollPane1.setViewportView(table1);

        p3.add(jScrollPane1);

        JPanel p4 = new JPanel();

        p4.setLayout(
                new BoxLayout(p4, BoxLayout.Y_AXIS));

        JLabel simulatie;

        simulatie = new JLabel("Logboek robot");

        p4.add(simulatie, Component.LEFT_ALIGNMENT);

        Database d2 = new Database();

        model3 = new DefaultTableModel();
        table1 = new JTable(model3);
        model3.addColumn("Ordernummer");
        model3.addColumn("Aantal artikelen");
        model3.addColumn("Aantal pakketten");
        model3.addColumn("Klant");
        model3.addColumn("Datum");
        //model3.addColumn("Algoritme TSP");
        //model3.addColumn("Algoritme BPP");
        table1.setEnabled(false);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.getTableHeader().setResizingAllowed(false);
        d2.Select();
        for (Logboek l : d2.getlist())
        {
            model3.addRow(new String[]
            {
                "" + l.getOrdernr() + "", "" + l.getAantalArtikkelen() + "", null, "" + l.getVoornaam() + " " + l.getAchternaam() + "", "" + l.getDatum() + ""
            });
        }

        jScrollPane1 = new JScrollPane();

        jScrollPane1.setViewportView(table1);

        p4.add(jScrollPane1);
        JLabel suggesties;

        suggesties = new JLabel("Suggesties");

        p4.add(suggesties);

        model4 = new DefaultTableModel();
        table1 = new JTable(model4);
        model4.addColumn("Product ID");
        model4.addColumn("Huidige Locatie");
        model4.addColumn("Voorgestelde Locatie");
        table1.setEnabled(false);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.getTableHeader().setResizingAllowed(false);
        d2.SelectArtikelTop();
        for (Artikel l2 : d2.getlistArtikel2())
        {
            model4.addRow(new String[]
            {
                "" + l2.getArtikelnr() + "", "" + l2.getPlaats() + "", null
            });
        }

        jScrollPane1 = new JScrollPane();

        jScrollPane1.setViewportView(table1);

        p4.add(jScrollPane1);
        JLabel bestVerkocht;

        bestVerkocht = new JLabel("Meest verkochte producten");

        p4.add(bestVerkocht);

        model5 = new DefaultTableModel();
        table1 = new JTable(model5);
        model5.addColumn("Product ID");
        model5.addColumn("Aantal keer verkocht");
        jScrollPane1 = new JScrollPane();

        for (Artikel l2 : d2.getlistArtikel2())
        {
            model5.addRow(new String[]
            {
                "" + l2.getArtikelnr() + "", "" + l2.getAantalArt() + ""
            });
        }

        jScrollPane1.setViewportView(table1);

        p4.add(jScrollPane1);

        p6.setLayout(new GridLayout(0, 1));

        jTabbedPane1 = new JTabbedPane();

        jTabbedPane1.addTab(
                "Huidige order", p2);
        jTabbedPane1.addTab(
                "Meldingen", p3);
        jTabbedPane1.addTab(
                "Statistieken", p4);
        jTabbedPane1.addTab("Magazijn", p6);

        add(jTabbedPane1);
        bestellingen = new ArrayList<Bestelling>();

        table1.setEnabled(false);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.getTableHeader().setResizingAllowed(false);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == selecteerXML)
        {
            cal = Calendar.getInstance();

            XmlParser dialoog = new XmlParser();

            boolean zitErin;
            zitErin = false;
            try
            {
                for (Bestelling b : bestellingen)
                {

                    if (b.getOrderNr() == dialoog.getBestelling().getOrderNr())
                    {
                        zitErin = true;

                        model2.addRow(new String[]
                        {
                            "Order bestaat al", "Error", "" + cal.getTime() + ""
                        });
                    }

                }

            }
            catch (Exception zz)
            {

                nietsselect = true;

            }

            if (!zitErin)
            {

                bestellingen.add(dialoog.getBestelling());
                if (dialoog.isGeselecteerd())
                {
                    model2.addRow(new String[]
                    {
                        "Nieuw order toegevoegd", "Action", "" + cal.getTime() + ""
                    });

                }
                else
                {
                    model2.addRow(new String[]
                    {
                        "Geen order toegevoegd", "Error", "" + cal.getTime() + ""
                    });

                }
            }

            dialoog.setVisible(false);
            Bestelling best = dialoog.getBestelling();
            try
            {
                model.addRow(new String[]
                {
                    "" + bestellingen.get(0).getOrderNr() + "", null, "" + bestellingen.get(0).getArtikelnrs() + "", "" + bestellingen.get(0).getKlant().getVoornaam() + " " + bestellingen.get(0).getKlant().getAchternaam()
                });

                artikelnrs = bestellingen.get(0).getArtikelnrs();

                // System.out.println(artikelen);
            }
            catch (Exception z)
            {

            }
            if (e.getSource() == selecteerXML)
            {
                if (ii > 0)
                {
                    try
                    {
                        model.removeRow(1);
                    }
                    catch (Exception zzzzzzz)
                    {
                    }
                }
                ii++;
            }
            int aantalRijen = model6.getRowCount();
            for (int i = aantalRijen - 1; i >= 0; i--)
            {
                model6.removeRow(i);
            }
            for (Bestelling b : bestellingen)
            {
                try
                {
                    model6.addRow(new String[]
                    {
                        "" + b.getOrderNr()
                    });
                }
                catch (Exception h)
                {

                }

            }

        }

        if (e.getSource() == startSysteem)
        {
            try
            {
                cal = Calendar.getInstance();
                p6.add(new TekenPanel(this));
                model2.addRow(new String[]
                        {
                                "Het Systeem is gestart", "Action", "" + cal.getTime() + ""
                        });
                startSysteem.setVisible(false);
                stopSysteem.setVisible(true);

                SimpelGretig sg = new SimpelGretig(bestellingen.get(0).getArtikelnrs(), this);
                sg.vul();
                bestellingen.get(0).setPakketten(sg.getAllePakketten());

            }
            catch (Exception e2)
            {
                model2.addRow(new String[]
                {
                    "Het systeem kon niet gestart worden", "Error", "" + cal.getTime() + ""
                });
            }

        }
        int i = 0;
        if (e.getSource() == stopSysteem)
        {
            p6.remove(0);
            cal = Calendar.getInstance();
            model2.addRow(new String[]
            {
                "Het systeem is gestopt", "Action", "" + cal.getTime() + ""
            });
            stopSysteem.setVisible(false);
            startSysteem.setVisible(true);

            for (Bestelling b : bestellingen)
            {
                i++;
            }

            Database d1 = new Database();
            try
            {
                d1.DatabaseBestelling(bestellingen.get(0).getOrderNr(), bestellingen.get(0).getDatum(), bestellingen.get(0).getKlant().getVoornaam(), bestellingen.get(0).getKlant().getAchternaam(), bestellingen.get(0).getArtikelnrs().size());
            }
            catch (Exception exc)
            {

            }
            try
            {
                ArrayList<Integer> artn = bestellingen.get(0).getArtikelnrs();

                int iiii = 0;
                for (int b : artn)
                {
                    d1.DatabaseBestelRegel(bestellingen.get(0).getOrderNr(), bestellingen.get(0).getArtikelnrs().get(iiii));
                    iiii++;
                }
            }
            catch (Exception e1)
            {

            }
            try
            {
                bestellingen.get(0).generatePakbonnen();
            }
            catch (Exception e2)
            {

            }

            if (i >= 2)
            {

                bestellingen.remove(0);
            }
            int aantalRijen = model3.getRowCount();
            for (int iii = aantalRijen - 1; iii >= 0; iii--)
            {
                model3.removeRow(iii);
            }
            d1.Select();
            for (Logboek l : d1.getlist())
            {
                model3.addRow(new String[]
                {
                    "" + l.getOrdernr() + "", "" + l.getAantalArtikkelen() + "", null, "" + l.getVoornaam() + " " + l.getAchternaam() + "", "" + l.getDatum() + ""
                });
            }
            int aantalRijen2 = model4.getRowCount();
            for (int iii = aantalRijen - 1; iii >= 0; iii--)
            {
                try
                {
                    model4.removeRow(iii);
                }
                catch (Exception ex)
                {

                }
            }
            d1.SelectArtikelTop();
            for (Artikel l2 : d1.getlistArtikel2())
            {
                model4.addRow(new String[]
                {
                    "" + l2.getArtikelnr() + "", "" + l2.getPlaats() + "", null
                });
            }
        }
        int aantalRijen = model6.getRowCount();
        for (int iii = aantalRijen - 1; iii >= 0; iii--)
        {
            model6.removeRow(iii);
        }
        try
        {
            for (Bestelling b : bestellingen)
            {
                try
                {
                    model6.addRow(new String[]
                    {
                        "" + b.getOrderNr()
                    });
                }
                catch (Exception z)
                {

                }
            }
        }
        catch (Exception e3)
        {

        }
        try
        {
            model.addRow(new String[]
            {
                "" + bestellingen.get(0).getOrderNr() + "", null, "" + bestellingen.get(0).getArtikelnrs() + "", "" + bestellingen.get(0).getKlant().getVoornaam() + " " + bestellingen.get(0).getKlant().getAchternaam()
            });

            if (ii > 0)
            {
                model.removeRow(0);

            }
            ii++;

        }
        catch (Exception zzz)
        {
        }
    }

    public ArrayList getArtikel()
    {
        return artikelnrs;
    }
}


	
	 


//}
