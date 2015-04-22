package ASRS;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

@SuppressWarnings("serial")
public class Scherm extends JFrame implements ActionListener {

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
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    private final JFileChooser jfc;

    public Scherm() {

        this.jfc = new JFileChooser();
        this.jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        this.jfc.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));

        //Hoofdscherm settings
        setTitle("AS/RS controle systeem");
        setLayout(new BorderLayout());
        setSize(1280, 720);
        setResizable(false);
        setVisible(true);

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
        p1.add(stopSysteem, BorderLayout.WEST);
        stopSysteem.addActionListener(this);
        startSysteem = new JButton("Start systeem");
        startSysteem.setPreferredSize(new Dimension(200, 40));
        p1.add(startSysteem, BorderLayout.WEST);
        startSysteem.addActionListener(this);
        genereerPakbon = new JButton("Genereer Pakbon");
        genereerPakbon.setPreferredSize(new Dimension(200, 40));
        p1.add(genereerPakbon, BorderLayout.WEST);
        genereerPakbon.addActionListener(this);

        //tabbladen
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(0, 1));
        model = new DefaultTableModel();
        table1 = new JTable(model);
        model.addColumn("Ordernummer");
        model.addColumn("Huidig Artikel");
        model.addColumn("Benodigde Pakketten");
        model.addColumn("Klant");


		
		jScrollPane1  = new JScrollPane();

    jScrollPane1.setViewportView (table1);

    p2.add(jScrollPane1);

    JPanel p3 = new JPanel();

    p3.setLayout (
    new GridLayout(0,1));
        model2 = new DefaultTableModel();
		table1  = new JTable(model2);
        model2.addColumn("Bericht");
        model2.addColumn("Type bericht");



		jScrollPane1  = new JScrollPane();

    jScrollPane1.setViewportView (table1);

    p3.add(jScrollPane1);

    JPanel p4 = new JPanel();

    p4.setLayout (
    new BoxLayout(p4, BoxLayout.Y_AXIS));
		
		JLabel simulatie;

    simulatie  = new JLabel("Logboek robot");

    p4.add (simulatie, Component.LEFT_ALIGNMENT );



        model3 = new DefaultTableModel();
        table1  = new JTable(model3);
        model3.addColumn("Ordernummer");
        model3.addColumn("Aantal artikelen");
        model3.addColumn("Aantal bins");
        model3.addColumn("Algoritme TSP");
        model3.addColumn("Algoritme BPP");


		jScrollPane1  = new JScrollPane();

    jScrollPane1.setViewportView (table1);

    p4.add(jScrollPane1);
    JLabel suggesties;

    suggesties  = new JLabel("Suggesties");

    p4.add (suggesties);

        model4 = new DefaultTableModel();
        table1  = new JTable(model4);
        model4.addColumn("Product ID");
        model4.addColumn("Huidige Locatie");
        model4.addColumn("Voorgestelde Locatie");

		jScrollPane1  = new JScrollPane();

    jScrollPane1.setViewportView (table1);

    p4.add(jScrollPane1);
    JLabel bestVerkocht;

    bestVerkocht  = new JLabel("Meest verkochte producten");

    p4.add (bestVerkocht);

        model5 = new DefaultTableModel();
        table1  = new JTable(model5);
        model5.addColumn("Product ID");

	jScrollPane1  = new JScrollPane();

    jScrollPane1.setViewportView (table1);

    p4.add(jScrollPane1);

//		JPanel p5 = new JPanel();
//		p2.setLayout(new GridLayout(0,1));
    jTabbedPane1  = new JTabbedPane();

    jTabbedPane1.addTab (

    "Huidige order", p2);
    jTabbedPane1.addTab (

    "Meldingen", p3);
    jTabbedPane1.addTab (

    "Statistieken", p4);
		//jTabbedPane1.addTab("Magazijn",p5);
		
    add(jTabbedPane1);

}
@Override
        public void actionPerformed(ActionEvent e)  {
		if(e.getSource()==selecteerXML){
//			xmlFilesBrowserActionPerformed();
			GuiHandler dialoog= new GuiHandler();
			dialoog.setVisible(false);
            Bestelling best = dialoog.bestelling;
            model.addRow(new String[]{"" + best.getOrdernr() + "", "NULL", "" + best.getArtikelnrs() + "", "" + best.getKlant().getVoornaam() + " " + best.getKlant().getAchternaam() });
			
			
		}
		
	}
	
	
	 


}
