import flightrising.core.*;
import flightrising.pairing.*;
import flightrising.xml_parser.*;

public class Main{
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Enter a file name.");
        } else {
            Colour test = Colour.MAIZE;
            Node<String> dataTree;
            XmlParser parser = new XmlParser(args[0]);
            dataTree = parser.parseXml();
        }
    }
}
