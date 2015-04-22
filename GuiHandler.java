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

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);

                            //optional, but recommended
                //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                doc.getDocumentElement().normalize();

                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                String ordernummer = doc.getElementsByTagName("ordernummer").item(0).getTextContent();
                String Datum =doc.getElementsByTagName("datum").item(0).getTextContent();

                //String artikelnummer=doc.getElementsByTagName("artikelnr").item(i).getTextContent();

                System.out.println("Ordernummer : " + ordernummer);
                System.out.println("Datum : " + Datum);

                NodeList artikelnr = doc.getElementsByTagName("artikelnr");
                //System.out.println(artikelnr.getLength());
                artikelnummer = new ArrayList<>();
                for (int i = 0; i < artikelnr.getLength(); i++) {
                    int iplus1 = i + 1;
                    artikelnummer.add(doc.getElementsByTagName("artikelnr").item(i).getTextContent());
                }
                System.out.println(artikelnummer);

                // klant subcategorie
                System.out.println("\n----------------------------");
                NodeList klant = doc.getElementsByTagName("klant");
                for (int temp = 0; temp < klant.getLength(); temp++) {
                    //System.out.println(klant.getLength());        
                    Node node = klant.item(temp);

                    System.out.println("Current SubElement :" + node.getNodeName() + "\n");

                    if (node.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) node;
                        String voornaam=eElement.getElementsByTagName("voornaam").item(0).getTextContent();
                        String achternaam=eElement.getElementsByTagName("achternaam").item(0).getTextContent();
                        String adres=eElement.getElementsByTagName("adres").item(0).getTextContent();
                        String postcode=eElement.getElementsByTagName("postcode").item(0).getTextContent();
                        String woonplaats=eElement.getElementsByTagName("plaats").item(0).getTextContent();

                        Klant klant1= new Klant(voornaam, achternaam, adres, woonplaats, postcode );


                        System.out.println(klant1);
                    }
                }
                System.out.println("----------------------------");

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
}
