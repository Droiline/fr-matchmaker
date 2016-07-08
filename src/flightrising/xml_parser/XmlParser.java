package flightrising.xml_parser;

import java.io.*;

// LOOK UP STRING BUILDER
// NOT CURRENTLY WORKING

public class XmlParser {
    private String filePath;
    private FileReader inFile;

    public XmlParser(String filePath) {
        this.filePath = filePath;
    }

// returns the base of the tree
    public Node<XmlElement> initialise() throws IOException, FileNotFoundException {
        inFile = new FileReader(filePath);

        char c;
        int count = 0;
        String buffer = new String("");
        boolean trunkFound = false;
        Node<XmlElement> trunk;

        while ((c = (char) inFile.read()) != EOF) {
            buffer += c;
            count++;

            if (count == 5) {
                if (!"<?xml".equals(buffer)) {
                    System.out.println("File is not xml");
                    throw IOException;
                }
            }

            if (count > 5) {
                System.out.println("File is xml");

                if (!trunkFound && c == '<') {
                    buffer = new String("");
                    trunkFound = true;
                }

                if (trunkFound && c == '>') {
                    buffer.substring(0, buffer.length() - 1);
                    trunk = Node<XmlElement>(buffer);
                    buffer = new String("");
                }

                if (trunkFound && )
            }
        }

        return new Node<XmlElement>("tag", "dud");
    }

    public Node<XmlElement> parseChildren(Node<XmlElement> element) {

    }
}
