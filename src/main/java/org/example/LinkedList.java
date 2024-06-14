package org.example;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class LinkedList<T> implements List<T>, Iterable<T> {
    private Node<T> head;
    private int listSize;

    public LinkedList() {
        this.listSize = 0;
    }

    public boolean add(T value) {
        if(head == null){
            head = new Node<>(value);
        }
        else {
            Node<T> currentNode = head.nextNode;
            Node<T> previousNode = head;
            while(currentNode != null){
                previousNode = currentNode;
                currentNode = currentNode.nextNode;
            }
            previousNode.nextNode = new Node<>(value);
        }

        listSize++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Iterator<T> iter = iterator();
        while(iter.hasNext()){
            Object element = iter.next();
            if(element != null && element.equals(o)){
                iter.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        HashSet<T> set = new HashSet<>(this);
        return set.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
        listSize = 0;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    public int size(){
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0 ? true : false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    public void remove() {
        if(listSize == 0){
            throw new NoSuchElementException("List is empty");
        }
        Iterator<T> iter = iterator();
        iter.next();
        iter.remove();
    }

    public T remove(int index) {
        T element = null;
        if(index > 0 && index < listSize){
            LinkedListIterator<T> iter = (LinkedListIterator<T>) iterator();
            for(int i = 0; i <= index; i++){
                iter.next();
            }
            element = iter.node.nodeValue;
            iter.remove();
        }
        else{
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return element;
    }

    // index of first instance of element in list or -1 if element doesn't exist
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    // index of last instance of element in list or -1 if element doesn't exist
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    public String toString() {
        return "LinkedList{"  + head.toString() + '}';
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[listSize];
        Iterator<T> iterator = new LinkedListIterator<>(this);
        for(int i = 0; i < listSize; i++){
            array[i] = iterator.next();
        }

        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
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

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }

    private static class LinkedListIterator<T> implements Iterator<T> {
        private final LinkedList<T> linkedList;
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
                throw new IllegalStateException("Exception: Iterator doesn't refer element");
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
