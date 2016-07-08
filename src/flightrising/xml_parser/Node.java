package flightrising.xml_parser;

import java.util.List;

public class Node<T> {
    private T data;
    private Node<T> parent;
    private List<Node<T>> children;

    public Node(T data) {
        this.data = data;
    }

    private Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    public Node<T> getParent() {
        return parent;
    }

    private void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void addChild(T data) {
        children.add(new Node<T>(data, this));
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
        children.add(child);
    }
}
