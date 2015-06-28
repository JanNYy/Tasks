package parser;

import entity.Gem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

import static parser.XMLValidator.validate;

public class GemSAXParser extends DefaultHandler {

    private static ArrayList<Gem> pavilion;
    private Gem currentGem;
    private Gem.VisualParameters currentVisualParameters;
    private StringBuilder dataBuffer;

    public static ArrayList<Gem> parseGem(String xml, String xsd) {

        if(!validate(xml, xsd)) throw new RuntimeException("XML file "+xml+" is not valid");

        pavilion = new ArrayList<Gem>();

        try
        {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new GemSAXParser();

            saxParser.parse(xml, handler);
        }

        catch(IOException | ParserConfigurationException | SAXException e)
        {
            System.out.println(e.getMessage());
        }

        return pavilion;
    }

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException {

        switch (qName)
        {
            case "gem":
            {
                currentGem = new Gem();
                currentGem.setGemID(attributes.getValue("id"));
                currentVisualParameters = new Gem.VisualParameters();
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        switch(qName)
        {
            case "gem":
            {
                currentGem.setVisualParameters(currentVisualParameters);
                pavilion.add(currentGem);
                break;
            }

            case "name":
            {
                currentGem.setName(dataBuffer.toString());
                break;
            }
            case "preciousness":
            {
                currentGem.setPreciousness(Gem.Preciousness.getPreciousness(dataBuffer.toString()));
                break;
            }
            case "origin":
            {
                currentGem.setOrigin(dataBuffer.toString());
                break;
            }
            case "color":
            {
                currentVisualParameters.setColor(Gem.VisualParameters.Color.getColor(dataBuffer.toString()));
                break;
            }
            case "transparency":
            {
                currentVisualParameters.setTransparency(Integer.parseInt(dataBuffer.toString()));
                break;
            }
            case "gem-cut":
            {
                currentVisualParameters.setGemCut(Integer.parseInt(dataBuffer.toString()));
                break;
            }
            case "value":
            {
                currentGem.setValue(Float.parseFloat(dataBuffer.toString()));
                break;
            }
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        dataBuffer = new StringBuilder();
        dataBuffer.append(ch, start, length);
    }

}

