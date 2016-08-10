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
            LinkedList<BreedingPair> pairs = new LinkedList<BreedingPair>();
            // double totalProb = 0;

            try {
                reader = new DrgReader(args[0]);
                lairs = reader.getLairs();

                lair = lairs[0];
                lair.mergeLairs(lairs[1]);
                lair.findRelations();

                target = lairs[2].getDragon(1);

                for (Map.Entry<Integer, Dragon> x : lair.getDragons().entrySet()) {
                    for (Map.Entry<Integer, Dragon> y : lair.getDragons().entrySet()) {
                        if (x.getKey() < y.getKey() && x.getValue().canBreedWith(y.getValue())) {
                            pair = new BreedingPair(x.getValue(), y.getValue());
                            pair.setBreedingProbability(target, true, true, false, true, true, true, false);

                            if (pair.getProbability() != 0.0) {
                                boolean inserted = false;
                                int count = 0;
                                System.out.println(lair.getDragon(pair.getIds()[0]).getName() + " and " + lair.getDragon(pair.getIds()[1]).getName() +
                                    ": " + pair.getProbability());

                                while (!inserted) {
                                    if (pairs.isEmpty()) {
                                        pairs.addFirst(pair);
                                        inserted = true;
                                    } else if (pairs.size() == count) {
                                        pairs.addLast(pair);
                                        inserted = true;
                                    } else if (pairs.get(count).getProbability() < pair.getProbability()) {
                                        pairs.add(count, pair);
                                        inserted = true;
                                    }
                                    count++;
                                }
                            }
                        }
                    }
                }

                LinkedList<Integer> inUse = new LinkedList<Integer>();
                System.out.println();
                for (BreedingPair p : pairs) {
                    if (!inUse.contains(p.getIds()[0]) && !inUse.contains(p.getIds()[1])) {
                        inUse.add(p.getIds()[0]);
                        inUse.add(p.getIds()[1]);
                        System.out.println(lair.getDragon(p.getIds()[0]).getName() + " and " + lair.getDragon(p.getIds()[1]).getName());
                    }
                }

                System.out.println();
                // System.out.println("Total probability: " + totalProb);
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
