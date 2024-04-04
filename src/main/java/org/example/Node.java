package org.example;

public class Node {
    Object nodeValue;
    Node nextNode;

    public Node(){
        this.nodeValue = null;
        this.nextNode = null;
    }

    public Node(Object value){
        this.nodeValue = value;
        this.nextNode = null;
    }

    public void setNodeValue(Object value){
        this.nodeValue = value;
    }

    public Object getNodeValue(){
        return this.nodeValue;
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
