import flightrising.core.*;
import flightrising.pairing.*;
// import flightrising.xml_parser.*;
import java.io.*;
import java.util.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;

public class Main{
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Give a filepath");
        } else {
            DrgReader reader;
            Lair lair;

            try {
                reader = new DrgReader(args[0]);
                lair = reader.getDragons();

                System.out.println("Before:");
                Dragon hen = lair.getDragon(24176883);
                System.out.println(hen);
                for (Integer x : hen.getRelatives()) {
                    if (lair.getDragons().containsKey(x)) {
                        System.out.print(lair.getDragon(x).getName() + " ");
                    }
                }
                System.out.println();
                Dragon chicken = lair.getDragon(23284403);
                System.out.println(chicken);
                for (Integer x : chicken.getRelatives()) {
                    if (lair.getDragons().containsKey(x)) {
                        System.out.print(lair.getDragon(x).getName() + " ");
                    }
                }
                System.out.println();
                Dragon rayman = lair.getDragon(24779997);
                System.out.println(rayman);
                for (Integer x : rayman.getRelatives()) {
                    if (lair.getDragons().containsKey(x)) {
                        System.out.print(lair.getDragon(x).getName() + " ");
                    }
                }
                System.out.println();
                System.out.println();

                lair.findRelations();

                System.out.println("After:");
                System.out.println(hen);
                for (Integer x : hen.getRelatives()) {
                    if (lair.getDragons().containsKey(x)) {
                        System.out.print(lair.getDragon(x).getName() + " ");
                    }
                }
                System.out.println();
                System.out.println(chicken);
                for (Integer x : chicken.getRelatives()) {
                    if (lair.getDragons().containsKey(x)) {
                        System.out.print(lair.getDragon(x).getName() + " ");
                    }
                }
                System.out.println();
                System.out.println(rayman);
                for (Integer x : rayman.getRelatives()) {
                    if (lair.getDragons().containsKey(x)) {
                        System.out.print(lair.getDragon(x).getName() + " ");
                    }
                }
                System.out.println();

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
