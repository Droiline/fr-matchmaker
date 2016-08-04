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

    public Lair getDragons() {
        NodeList nodes = doc.getElementsByTagName("Dragon");
        Element current;
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
        Lair lair = new Lair();

        for (int i = 0; i < nodes.getLength(); i++) {
            HashSet<Integer> relativeSet = new HashSet<Integer>();
            current = (Element) nodes.item(i);
            breed = Breed.valueOf(current.getElementsByTagName("breed").item(0).getTextContent().toUpperCase());
            gender = current.getElementsByTagName("matingType").item(0).getTextContent() == "true" ? FEMALE : MALE;

            section = (Element) current.getElementsByTagName("primary").item(0);
            primCol = Colour.valueOf(section.getElementsByTagName("color").item(0).getTextContent().toUpperCase());
            primGene = PrimaryGene.valueOf(section.getElementsByTagName("gene").item(0).getTextContent().toUpperCase());
            section = (Element) current.getElementsByTagName("secondary").item(0);
            secCol = Colour.valueOf(section.getElementsByTagName("color").item(0).getTextContent().toUpperCase());
            secGene = SecondaryGene.valueOf(section.getElementsByTagName("gene").item(0).getTextContent().toUpperCase());
            section = (Element) current.getElementsByTagName("tertiary").item(0);
            tertCol = Colour.valueOf(section.getElementsByTagName("color").item(0).getTextContent().toUpperCase());
            tertGene = TertiaryGene.valueOf(section.getElementsByTagName("gene").item(0).getTextContent().toUpperCase());

            parentString = current.getElementsByTagName("parents").item(0).getTextContent();
            relativeString = current.getElementsByTagName("relatives").item(0).getTextContent();

            if(!parentString.isEmpty()) {
                stringList = parentString.split(" ");

                for (int j = 0; j < stringList.length; j++) {
                    relativeSet.add(Integer.parseInt(stringList[j]));
                }
            }

            if(!relativeString.isEmpty()) {
                stringList = relativeString.split(" ");

                for (int j = 0; j < stringList.length; j++) {
                    relativeSet.add(Integer.parseInt(stringList[j]));
                }
            }

            dragon = new Dragon(Integer.parseInt(current.getElementsByTagName("id").item(0).getTextContent()),
                                    current.getElementsByTagName("name").item(0).getTextContent(),
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

        return lair;
    }
}
