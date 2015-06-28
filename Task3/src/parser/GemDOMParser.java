package parser;

import entity.Gem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import static parser.XMLValidator.validate;

public class GemDOMParser {

    public static ArrayList<Gem> parseGem(String xml, String xsd) {

        if(!validate(xml, xsd)) throw new RuntimeException("XML file "+xml+" is not valid");

        ArrayList<Gem> pavilion = new ArrayList<Gem>();

        DocumentBuilder dBuilder;
        Document document;
        try
        {
            dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = dBuilder.parse(xml);

        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            System.out.println(e.getMessage());
            return null;
        }

        NodeList nodeList = document.getElementsByTagName("gem");

        for(int i = 0; i < nodeList.getLength(); i++)
        {
            Node current = nodeList.item(i);
            pavilion.add(parseElement((Element) current));
        }
        return pavilion;
    }

    private static Gem parseElement(Element element) {

        Gem gem = new Gem();
        gem.setGemID(element.getAttribute("id"));

        gem.setName(element.getElementsByTagName("name").item(0).getTextContent());
        gem.setPreciousness(Gem.Preciousness.getPreciousness(element.getElementsByTagName("preciousness").item(0).getTextContent()));
        gem.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());
        gem.setValue(Float.parseFloat(element.getElementsByTagName("value").item(0).getTextContent()));

        Gem.VisualParameters visualParameters = new Gem.VisualParameters();

        visualParameters.setColor(Gem.VisualParameters.Color.getColor(element.getElementsByTagName("color").item(0).getTextContent()));
        visualParameters.setTransparency(Integer.parseInt(element.getElementsByTagName("transparency").item(0).getTextContent()));
        visualParameters.setGemCut(Integer.parseInt(element.getElementsByTagName("gem-cut").item(0).getTextContent()));

        gem.setVisualParameters(visualParameters);

        return gem;
    }
}
