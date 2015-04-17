/**
 * --- XML Parser ---
 * This class parses an XML file and uses it to create
 * a new order to simulate in the TSP-algorithm.
 */
package Algorithm;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {

    public static void main(String argv[]) {

        try {

            File fXmlFile = new File("C:\\Users\\Wessel\\Desktop\\TSP\\TSP\\src\\Algorithm\\info.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            System.out.println("Ordernummer : " + doc.getElementsByTagName("ordernummer").item(0).getTextContent());
            System.out.println("Datum : " + doc.getElementsByTagName("datum").item(0).getTextContent());

            System.out.println("Artikelnummer : " + doc.getElementsByTagName("artikelnr").item(0).getTextContent());

            // klant subcategorie
            System.out.println("\n----------------------------");
            NodeList klant = doc.getElementsByTagName("klant");
            for (int temp = 0; temp < klant.getLength(); temp++) {

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


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}