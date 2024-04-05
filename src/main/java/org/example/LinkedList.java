package org.example;

public class LinkedList<T> {
    Node<T> head;
    int listSize;
    public LinkedList(){
        this.listSize = 0;
    }

    public void add(T value) {
        if(head == null){
            head = new Node<>(value);
        }
        else{
            Node<T> currentNode = head.getNextNode();
            Node<T> previousNode = head;
            while(currentNode != null){
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            previousNode.setNextNode(new Node<>(value));
        }

        listSize++;
    }

    public int size(){
        return listSize;
    }

    public void remove(){
        head = head.getNextNode();
        listSize--;
    }

    public void remove(int index){
        if(index > 0 || index < listSize - 1){
            Node<T> currentNode = head.getNextNode();
            Node<T> previousNode = head;
            int count = 1;
            while(count != index){
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
                count++;
            }
            previousNode.setNextNode(currentNode.getNextNode());
            listSize--;
        }
        else{
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public String toString() {
        return "LinkedList{"  + head.toString() + '}';
    }
}
