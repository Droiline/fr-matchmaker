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
            Lair[] lairs;
            Lair lair;
            Dragon target;
            BreedingPair pair;

            try {
                reader = new DrgReader(args[0]);
                lairs = reader.getLairs();

                System.out.println(lairs.length + " lairs found.");

                lair = lairs[0];
                lair.mergeLairs(lairs[1]);

                Dragon melia = lair.getDragon(19263265);
                Dragon magi = lair.getDragon(24678456);

                target = lairs[2].getDragon(2);
                pair = new BreedingPair(melia, magi);

                System.out.println("Target: ");
                System.out.println(target);
                System.out.println("Parents: ");
                System.out.println(melia);
                System.out.println(magi);
                System.out.println("Pair: ");
                System.out.println(pair);
                System.out.println();
                System.out.println("Probability: " + pair.getBreedingProbability(target, true, true, false, true, true, true, false) * 100 + "%");

            } catch (ParserConfigurationException e) {
                System.out.println("Couldn't configure parser.");
            } catch (SAXException e) {
                System.out.println("Syntax error on the data file.");
            } catch (IOException e) {
                System.out.println("IOException");
            }
        }
    }
}
