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
    private JTabbedPane jTabbedPane1;
    private JTable table1;
    private JScrollPane jScrollPane1;
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

        //tabbladen
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(0, 1));
        table1 = new JTable();
        table1.setModel(new DefaultTableModel(new Object[][]{{ null, null, null, null}},
                new String[]{"Ordernummer", "Huidig artikel", "Benodigde pakketten", "Klant"}));
	 	
		
		jScrollPane1  = new JScrollPane();

    jScrollPane1.setViewportView (table1);

    p2.add (jScrollPane1);

    JPanel p3 = new JPanel();

    p3.setLayout (
    new GridLayout(0,1));	
		table1  = new JTable();

    table1.setModel ( 
        new DefaultTableModel(new Object[][]{{null
        
    
    , null}} ,
    new String[]

    {
        "Type Bericht", "Bericht"}));
		jScrollPane1  = new JScrollPane();

    jScrollPane1.setViewportView (table1);

    p3.add (jScrollPane1);

    JPanel p4 = new JPanel();

    p4.setLayout (
    new BoxLayout(p4, BoxLayout.Y_AXIS));
		
		JLabel simulatie;

    simulatie  = new JLabel("Logboek robot");

    p4.add (simulatie, Component.LEFT_ALIGNMENT );

    table1  = new JTable();

    table1.setModel ( 
        new DefaultTableModel(new Object[][]{{ null, null, null, null, null}} ,
    new String[]

    {
        "Ordernummer", "Aantal artikelen", "Aantal bins", "Algoritme TSP", "Algormitme BPP"}));
		jScrollPane1  = new JScrollPane();

    jScrollPane1.setViewportView (table1);

    p4.add (jScrollPane1);
    JLabel suggesties;

    suggesties  = new JLabel("suggesties");

    p4.add (suggesties);

    table1  = new JTable();

    table1.setModel ( 
        new DefaultTableModel(new Object[][]{{null
        
    
    , null, null}} ,
    new String[]

    {
        "Product ID"
    
    , "Huidige locatie", "Voorgestelde locaties"}));
		jScrollPane1  = new JScrollPane();

    jScrollPane1.setViewportView (table1);

    p4.add (jScrollPane1);
    JLabel bestVerkocht;

    bestVerkocht  = new JLabel("meest verkochte producten");

    p4.add (bestVerkocht);

    table1  = new JTable();

    table1.setModel ( 
        new DefaultTableModel(new Object[][]{{null
        }
    }
     ,
    new String[]

    {
        "Product ID"
    }
    ));
	jScrollPane1  = new JScrollPane();

    jScrollPane1.setViewportView (table1);

    p4.add (jScrollPane1);

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
			
			
		}
		
	}
	
	
	 


}
