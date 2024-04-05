package org.example;

public class Node<T> {
    Object nodeValue;
    Node nextNode;

    public Node(){
        this.nodeValue = null;
        this.nextNode = null;
    }

    public Node(T value){
        this.nodeValue = value;
        this.nextNode = null;
    }

    public void setNodeValue(T value){
        this.nodeValue = value;
    }

    public T getNodeValue(){
        return (T) this.nodeValue;
    }

    public Node getNextNode(){
        return nextNode;
    }

    public void setNextNode(Node node){
        this.nextNode = node;
    }

    @Override
    public String toString() {
        return nodeValue + " : " + nextNode;
    }
}
