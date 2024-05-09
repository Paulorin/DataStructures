package org.example;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// Implement DoublyLinkedList class with main methods
// Implement internal Node class
// Implement Iterator
// Implement List methods
public class DoublyLinkedList<T> implements List<T> {
    private Node<T> head;
    private int listSize;
    public DoublyLinkedList() {
        this.listSize = 0;
    }

    @Override
    public int size() {
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

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
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

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

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

    private class Node<T> {
        private T nodeValue;
        private Node<T> previousNode;
        private Node<T> nextNode;
        private Node(){
            this.nodeValue = null;
            this.nextNode = null;
            this.previousNode = null;
        }

        private Node(T value){
            this.nodeValue = value;
            this.nextNode = null;
            this.previousNode = null;
        }
    }

    private class DoublyLinkedListIterator<T> implements ListIterator<T>{

        private DoublyLinkedList<T> doublyLinkedList;
        private Node<T> node;
        private Node<T> previousNode;
        private Node<T> nextNode;
        @Override
        public boolean hasNext() {
            return node.nextNode != null;
        }

        /*
        Next() is a method that should reset iterator to the next list element.
        What that involves is:
        -
         */
        @Override
        public T next() {
            if(node.nextNode == null){
                throw new NoSuchElementException("Error");
            }
            if(node.nextNode != doublyLinkedList.head){
                previousNode = node;
            }
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return node.previousNode != null;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }
}
