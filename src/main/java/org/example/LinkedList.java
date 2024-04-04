package org.example;

public class LinkedList {
    Node head;
    public LinkedList(){
        this.head = new Node();
    }
    
    public void add(Object value) {
        if (head.getNodeValue() == null) {
            head.setNodeValue(value);
        }
        else {
            Node currentNode = head.getNextNode();
            Node previousNode = head;
            while(currentNode != null){
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            previousNode.setNextNode(new Node(value));
        }
    }

    @Override
    public String toString() {
        return "LinkedList{"  + head.toString() + '}';
    }
}
