package flightrising.xml_parser;

public class XmlElement {
    private String tag;
    private String content;

    XmlElement(String tag) {
        this.tag = tag;
        content = "empty";
    }

    XmlElement(String tag, String content) {
        this.tag = tag;
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }
}
