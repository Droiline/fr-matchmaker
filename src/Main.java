import flightrising.core.*;
import flightrising.pairing.*;
import flightrising.xml_parser.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Enter a file name.");
        } else {
            Colour test = Colour.MAIZE;
            Node<String> dataTree;
            XmlParser parser = new XmlParser(args[0]);

            try {
                dataTree = parser.parseXml();
            } catch (FileNotFoundException e) {
                System.out.println("Invalid filepath.");
            } catch (IOException e) {
                System.out.println("Could not read file.");
            }
        }
    }
}
