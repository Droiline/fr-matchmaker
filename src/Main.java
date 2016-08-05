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
            int dudeId = 25626395;
            int laddyId = 25757445;
            Dragon dude;
            Dragon laddy;
            Boolean canBreed;
            BreedingPair pair;

            try {
                reader = new DrgReader(args[0]);
                lair = reader.getDragons();

                lair.findRelations();

                dude = lair.getDragon(dudeId);
                laddy = lair.getDragon(laddyId);

                canBreed = dude.canBreedWith(laddy);
                System.out.println(dude.getName() + " and " +
                        laddy.getName() + " can breed: " + canBreed);
                System.out.println();
                
                pair = new BreedingPair(dude, laddy);

                System.out.println(pair);

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
