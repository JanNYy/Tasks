package parser;

import entity.Gem;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static parser.XMLValidator.validate;

public class GemStAXParser {

    public static ArrayList<Gem> parseGem(String xml, String xsd) {

        if (!validate(xml, xsd)) throw new RuntimeException("XML file "+xml+" is not valid");

        XMLInputFactory factory = XMLInputFactory.newInstance();

        XMLStreamReader gemReader;
        try
        {
            gemReader = factory.createXMLStreamReader(new FileInputStream(xml));
        }
        catch (XMLStreamException | FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            return null;
        }

        ArrayList<Gem> gemList = new ArrayList<Gem>();
        Gem currentGem = new Gem();
        Gem.VisualParameters currentVisualParameters = new Gem.VisualParameters();

        String data = "";

        try
        {
            while (gemReader.hasNext())
            {
                int event = gemReader.next();
                switch (event)
                {
                    case XMLStreamConstants.START_ELEMENT:
                    {
                        if (gemReader.getLocalName().equals("gem"))
                        {
                            currentGem = new Gem();
                            currentVisualParameters = new Gem.VisualParameters();
                            currentGem.setGemID(gemReader.getAttributeValue(0));
                        }
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:
                    {
                        data = gemReader.getText();
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:
                    {
                        switch (gemReader.getLocalName())
                        {
                            case "name":
                            {
                                currentGem.setName(data);
                                break;
                            }
                            case "preciousness":
                            {
                                currentGem.setPreciousness(Gem.Preciousness.getPreciousness(data));
                                break;
                            }
                            case "origin":
                            {
                                currentGem.setOrigin(data);
                                break;
                            }
                            case "color":
                            {
                                currentVisualParameters.setColor(Gem.VisualParameters.Color.getColor(data));
                                break;
                            }
                            case "transparency":
                            {
                                currentVisualParameters.setTransparency(Integer.parseInt(data));
                                break;
                            }
                            case "gem-cut":
                            {
                                currentVisualParameters.setGemCut(Integer.parseInt(data));
                                break;
                            }
                            case "value":
                            {
                                currentGem.setValue(Float.parseFloat(data));
                                break;
                            }
                            case "gem":
                            {
                                currentGem.setVisualParameters(currentVisualParameters);
                                gemList.add(currentGem);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            return gemList;
        }
        catch (XMLStreamException e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }

}
