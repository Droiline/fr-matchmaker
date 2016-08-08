package flightrising.core;

import java.io.*;
import java.util.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;

import static flightrising.core.Gender.*;

public class DrgReader {
    private Document doc;

    public DrgReader(String filepath) throws ParserConfigurationException, SAXException, IOException {
        File file = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse(file);
    }

    public Document getDoc() {
        return doc;
    }

    public Lair[] getLairs() {
        NodeList lairNodes = doc.getElementsByTagName("Lair");
        Element currentLair;
        NodeList dragonNodes;
        Element currentDragon;
        Element section;
        Breed breed;
        Gender gender;
        Colour primCol;
        Colour secCol;
        Colour tertCol;
        PrimaryGene primGene;
        SecondaryGene secGene;
        TertiaryGene tertGene;
        String parentString;
        String relativeString;
        String[] stringList;
        Dragon dragon;
        Lair lair;
        Lair[] lairs = new Lair[lairNodes.getLength()];

        for (int i = 0; i < lairNodes.getLength(); i++) {
            currentLair = (Element) lairNodes.item(i);
            dragonNodes = currentLair.getElementsByTagName("Dragon");

            lair = new Lair();

            for (int j = 0; j < dragonNodes.getLength(); j++) {
                TreeSet<Integer> relativeSet = new TreeSet<Integer>();
                currentDragon = (Element) dragonNodes.item(j);
                breed = Breed.valueOf(currentDragon.getElementsByTagName("breed").item(0).getTextContent().toUpperCase());
                gender = currentDragon.getElementsByTagName("matingType").item(0).getTextContent() == "true" ? FEMALE : MALE;

                section = (Element) currentDragon.getElementsByTagName("primary").item(0);
                primCol = Colour.valueOf(section.getElementsByTagName("color").item(0).getTextContent().toUpperCase());
                primGene = PrimaryGene.valueOf(section.getElementsByTagName("gene").item(0).getTextContent().toUpperCase());
                section = (Element) currentDragon.getElementsByTagName("secondary").item(0);
                secCol = Colour.valueOf(section.getElementsByTagName("color").item(0).getTextContent().toUpperCase());
                secGene = SecondaryGene.valueOf(section.getElementsByTagName("gene").item(0).getTextContent().toUpperCase());
                section = (Element) currentDragon.getElementsByTagName("tertiary").item(0);
                tertCol = Colour.valueOf(section.getElementsByTagName("color").item(0).getTextContent().toUpperCase());
                tertGene = TertiaryGene.valueOf(section.getElementsByTagName("gene").item(0).getTextContent().toUpperCase());

                if (currentDragon.getElementsByTagName("parents").getLength() != 0) {
                    parentString = currentDragon.getElementsByTagName("parents").item(0).getTextContent();

                    if(!parentString.isEmpty()) {
                        stringList = parentString.split(" ");

                        for (int k = 0; k < stringList.length; k++) {
                            relativeSet.add(Integer.parseInt(stringList[k]));
                        }
                    }
                }

                if (currentDragon.getElementsByTagName("relatives").getLength() != 0) {
                    relativeString = currentDragon.getElementsByTagName("relatives").item(0).getTextContent();

                    if(!relativeString.isEmpty()) {
                        stringList = relativeString.split(" ");

                        for (int k = 0; k < stringList.length; k++) {
                            relativeSet.add(Integer.parseInt(stringList[k]));
                        }
                    }
                }

                dragon = new Dragon(Integer.parseInt(currentDragon.getElementsByTagName("id").item(0).getTextContent()),
                                        currentDragon.getElementsByTagName("name").item(0).getTextContent(),
                                        breed,
                                        gender,
                                        primCol,
                                        secCol,
                                        tertCol,
                                        primGene,
                                        secGene,
                                        tertGene,
                                        relativeSet);
                lair.addDragon(dragon);
            }

            lairs[i] = lair;
        }

        return lairs;
    }
}
