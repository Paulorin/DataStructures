package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * To do:
 * Create add methods to insert element in linked list,
 * Understand how to implement iterator in linked list datastructure
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T>{
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
        if(index > 0 && index < listSize){
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

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }

    private static class Node<T> {
        private T nodeValue;
        private Node<T> nextNode;

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
            return this.nodeValue;
        }

        public Node<T> getNextNode(){
            return nextNode;
        }

        public void setNextNode(Node<T> node){
            this.nextNode = node;
        }

        @Override
        public String toString() {
            return nodeValue + " : " + nextNode;
        }
    }

    private static class LinkedListIterator<T> implements Iterator<T> {
        private LinkedList<T> linkedList;
        private Node<T> node;
        private Node<T> previousNode;

        private LinkedListIterator(LinkedList<T> list){
            this.linkedList = list;
            this.node = new Node<>();
            node.nextNode = list.head;
            this.previousNode = null;
        }
        @Override
        public boolean hasNext() {
            return node.nextNode != null;
        }

        @Override
        public T next() {
            if(node.nextNode == null){
                throw new NoSuchElementException("Error");
            }
            if(node.nextNode != linkedList.head){
                previousNode = node;
            }
            else{
                previousNode = linkedList.head;
            }
            node = node.nextNode;
            return node.nodeValue;
        }

        @Override
        public void remove() {
            if(node.nextNode == linkedList.head){
                throw new IllegalStateException("Error iterator doesn't refere element");
            }
            if(previousNode == node){
                linkedList.head = node.nextNode;
            }
            else{
                previousNode.nextNode = node.nextNode;
            }
            linkedList.listSize--;
        }
    }
}
