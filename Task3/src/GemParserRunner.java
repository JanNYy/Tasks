import entity.Gem;
import parser.GemDOMParser;
import parser.GemSAXParser;
import parser.GemStAXParser;
import parser.GemXMLWriter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;

public class GemParserRunner {

    public static void main(String[] args) {

        String xsd = "src/xml/gem.xsd";
        String xml = "src/xml/gem.xml";

        ArrayList<Gem> pavilion;

        System.out.println("----- SAX parser -----");
        pavilion = GemSAXParser.parseGem(xml,xsd);
        System.out.println(pavilion);

        System.out.println();

        System.out.println("----- DOM parser -----");
        pavilion = GemDOMParser.parseGem(xml,xsd);
        System.out.println(pavilion);

        System.out.println();

        System.out.println("----- StAX parser -----");
        pavilion = GemStAXParser.parseGem(xml,xsd);
        System.out.println(pavilion);

        try
        {
            GemXMLWriter.writeXML(pavilion, "src/xml/gem_generated.xml");
        }
        catch (ParserConfigurationException | TransformerException e )
        {
            System.out.println(e.getMessage());
        }

    }
}
