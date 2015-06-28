package parser;

import entity.Gem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class GemXMLWriter {

    public static void writeXML(ArrayList<Gem> gemList, String toXML)
            throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument();
        Element root = document.createElement("pavilion");
        document.appendChild(root);

        for(Gem gemElement : gemList)
        {
            Element gem = document.createElement("gem");
            gem.setAttribute("id", gemElement.getGemID());

            Element name = document.createElement("name");
            name.appendChild(document.createTextNode(gemElement.getName()));
            gem.appendChild(name);

            Element preciousness = document.createElement("preciousness");
            preciousness.appendChild(document.createTextNode(gemElement.getPreciousness().toString()));
            gem.appendChild(preciousness);

            Element origin = document.createElement("origin");
            origin.appendChild(document.createTextNode(gemElement.getOrigin()));
            gem.appendChild(origin);

            Element visualParameters = document.createElement("visualParameters");

            Element color = document.createElement("color");
            color.appendChild(document.createTextNode(gemElement.getVisualParameters().getColor().toString()));
            visualParameters.appendChild(color);

            Element transparency = document.createElement("transparency");
            transparency.appendChild(document.createTextNode(Integer.toString(gemElement.getVisualParameters().getTransparency())));
            visualParameters.appendChild(transparency);

            Element gemCut = document.createElement("gem-cut");
            gemCut.appendChild(document.createTextNode(Integer.toString(gemElement.getVisualParameters().getGemCut())));
            visualParameters.appendChild(gemCut);

            gem.appendChild(visualParameters);

            Element value = document.createElement("value");
            value.appendChild(document.createTextNode(Float.toString(gemElement.getValue())));
            gem.appendChild(value);

            root.appendChild(gem);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(toXML));

        transformer.transform(source, result);
    }

}
