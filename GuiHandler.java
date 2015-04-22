package ASRS;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("serial")
public class GuiHandler extends JFrame {

    private final JFileChooser jfc;
    ArrayList<String> artikelnummer;
    Klant klant;


    public GuiHandler() {


        this.jfc = new JFileChooser();
        this.jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        this.jfc.setFileFilter(new FileNameExtensionFilter("XML files (*.xml)", "xml"));

        xmlFileUitlezen();
    }

    protected void xmlFileUitlezen() {
        final File xmlFile = getXmlFile();
        if (xmlFile != null) {

            try {
                
                //setup
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);
                doc.getDocumentElement().normalize();
                
                
                //xml waarden in attributen stoppen
                String ordernummer = doc.getElementsByTagName("ordernummer").item(0).getTextContent();
                int ordernr = Integer.parseInt(ordernummer);
                
                String datum =doc.getElementsByTagName("datum").item(0).getTextContent();
                
                NodeList artikelnr = doc.getElementsByTagName("artikelnr");
                
                artikelnummer = new ArrayList<>();
                for (int i = 0; i < artikelnr.getLength(); i++) {
                    int iplus1 = i + 1;
                    artikelnummer.add(doc.getElementsByTagName("artikelnr").item(i).getTextContent());
                }
                
                //xml waarden in klasse Klant stoppen
                subcatKlantUitlezen(doc);
                
                //attributen in klasse Bestelling stoppen
                Bestelling bestelling = new Bestelling(ordernr, datum, artikelnummer, klant );
                
                System.out.println(bestelling);
                
                

            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public File getXmlFile() {
	        // At this point we should be on the event dispatch thread,
        // so there is no need to call SwingUtilities.invokeLater
        // or SwingUtilities.invokeAndWait.
        if (this.jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return this.jfc.getSelectedFile();
        }
        return null;
    }
    
    public void subcatKlantUitlezen(Document doc) {
        NodeList klantList = doc.getElementsByTagName("klant");
        for (int temp = 0; temp < klantList.getLength(); temp++) {

            Node node = klantList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) node;
                String voornaam = eElement.getElementsByTagName("voornaam").item(0).getTextContent();
                String achternaam = eElement.getElementsByTagName("achternaam").item(0).getTextContent();
                String adres = eElement.getElementsByTagName("adres").item(0).getTextContent();
                String postcode = eElement.getElementsByTagName("postcode").item(0).getTextContent();
                String woonplaats = eElement.getElementsByTagName("plaats").item(0).getTextContent();

                klant = new Klant(voornaam, achternaam, adres, woonplaats, postcode);
            }
        }
    }
}
