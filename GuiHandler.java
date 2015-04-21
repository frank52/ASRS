package ASRS;

import java.io.File;

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

                System.out.println("Ordernummer : " + doc.getElementsByTagName("ordernummer").item(0).getTextContent());
                System.out.println("Datum : " + doc.getElementsByTagName("datum").item(0).getTextContent());

                NodeList artikelnr = doc.getElementsByTagName("artikelnr");
                //System.out.println(artikelnr.getLength());

                for (int i = 0; i < artikelnr.getLength(); i++) {
                    int iplus1 = i + 1;
                    System.out.println("Artikelnummer " + iplus1 + ": " + doc.getElementsByTagName("artikelnr").item(i).getTextContent());
                }

                // klant subcategorie
                System.out.println("\n----------------------------");
                NodeList klant = doc.getElementsByTagName("klant");
                for (int temp = 0; temp < klant.getLength(); temp++) {
                    //System.out.println(klant.getLength());        
                    Node node = klant.item(temp);

                    System.out.println("Current SubElement :" + node.getNodeName() + "\n");

                    if (node.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) node;

                        System.out.println("Voornaam : " + eElement.getElementsByTagName("voornaam").item(0).getTextContent());
                        System.out.println("Achternaam : " + eElement.getElementsByTagName("achternaam").item(0).getTextContent());
                        System.out.println("Adres : " + eElement.getElementsByTagName("adres").item(0).getTextContent());
                        System.out.println("Postcode : " + eElement.getElementsByTagName("postcode").item(0).getTextContent());
                        System.out.println("Plaats : " + eElement.getElementsByTagName("plaats").item(0).getTextContent());
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
