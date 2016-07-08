package flightrising.xml_parser;

import java.util.ArrayList;

public class Node<T> {
    private T datum;
    private Node<T> parent;
    private ArrayList<Node<T>> children;

    public Node(T data) {
        this.datum = datum;
        children = new ArrayList<Node<T>>();
    }

    private Node(T data, Node<T> parent) {
        this.datum = datum;
        this.parent = parent;
        children = new ArrayList<Node<T>>();
    }

    public T getDatum() {
        return datum;
    }

    public Node<T> getParent() {
        return parent;
    }

    private void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void addChild(T datum) {
        children.add(new Node<T>(datum, this));
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
        children.add(child);
    }

    public boolean hasChild(Node<T> node) {
        if (children.isEmpty()) {
            return false;
        } else {
            return false;
        }
    }
}
