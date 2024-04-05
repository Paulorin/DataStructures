package org.example;

public class LinkedList<T>{
    Node<T> head;


    public void add(T value) {
        if(head == null){
            head = new Node(value);
        }
        else{
            Node currentNode = head.getNextNode();
            Node previousNode = head;
            while(currentNode != null){
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            previousNode.setNextNode(new Node(value));
        }
    }


    public int size(){
        if(head == null){
            return 0;
        }
        else {
            int size = 1;
            Node nextNode = head.getNextNode();
            while (nextNode != null) {
                nextNode = nextNode.getNextNode();
                size++;
            }
            return size;
        }
    }


    public String toString() {
        return "LinkedList{"  + head.toString() + '}';
    }
}
