import flightrising.core.*;
import flightrising.pairing.*;
// import flightrising.xml_parser.*;
import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;

public class Main{
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Give a filepath");
        } else {
            DrgReader reader;
            Dragon[] input;

            try {
                reader = new DrgReader(args[0]);

                input = reader.getDragons();
                System.out.println(input[0].toString());
            } catch (ParserConfigurationException e) {
                System.out.println("Couldn't configure parser.");
            } catch (SAXException e) {
                System.out.println("What is a SAXException?");
            } catch (IOException e) {
                System.out.println("IOException");
            }
        }
    }
}
