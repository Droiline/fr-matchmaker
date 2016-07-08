package flightrising.xml_parser;

import java.io.*;

public class XmlParser {
    private String filePath;
    private FileReader inFile;

    public XmlParser(String filePath) {
        this.filePath = filePath;
    }

// returns the base of the tree
    public Node<String> parseXml() {
        try {
            inFile = new FileReader(filePath);

            int c;
            while ((c = inFile.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            inFile = null;
        }

        return new Node<String>("dud");
    }
}
