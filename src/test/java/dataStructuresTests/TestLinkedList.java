package dataStructuresTests;

import org.example.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLinkedList {

    @Test
    public void ShouldAddOneValueToList(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        assertThat(linkedList.size()).isEqualTo(1);

        System.out.println(linkedList.toString());
    }

    @Test
    public void ShouldAddTwoValuesToList(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        assertThat(linkedList.size()).isEqualTo(2);

        System.out.println(linkedList.toString());
    }

    @Test
    public void ShouldAddThreeValuesToList(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertThat(linkedList.size()).isEqualTo(3);

        System.out.println(linkedList.toString());
    }

    @Test
    public void ShouldAddFourValuesToList(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        assertThat(linkedList.size()).isEqualTo(4);

        System.out.println(linkedList.toString());
    }

    @Test
    public void ShouldReturnSizeOfLinkedList(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        assertThat(linkedList.size()).isEqualTo(4);

        System.out.println(linkedList.toString());
        System.out.println(linkedList.size());
    }

    @Test
    public void ShouldRemoveFirstElement(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        assertThat(linkedList.size()).isEqualTo(4);

        System.out.println(">> Before removal:");
        System.out.println(linkedList.toString());
        System.out.println(linkedList.size());

        System.out.println(">> After removal:");
        linkedList.remove();
        System.out.println(linkedList.toString());
        System.out.println(linkedList.size());

        assertThat(linkedList.size()).isEqualTo(3);
    }

    @Test
    public void ShouldRemoveElementByIndex(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        assertThat(linkedList.size()).isEqualTo(4);

        System.out.println(">> Before removal:");
        System.out.println(linkedList.toString());
        System.out.println(linkedList.size());

        System.out.println(">> After removal:");
        linkedList.remove(1);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.size());

        assertThat(linkedList.size()).isEqualTo(3);
    }

    @Test
    public void ShouldRemoveLastElement(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        assertThat(linkedList.size()).isEqualTo(5);

        System.out.println(">> Before removal:");
        System.out.println(linkedList.toString());
        System.out.println(linkedList.size());

        System.out.println(">> After removal:");
        linkedList.remove(4);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.size());

        assertThat(linkedList.size()).isEqualTo(4);
    }

    @Test
    public void ShouldThrowOutOfBoundException(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        assertThat(linkedList.size()).isEqualTo(5);


        boolean exceptionThrown = false;
        try{
            linkedList.remove(7);
        }
        catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }

        assertThat(exceptionThrown).isTrue();
    }

    @Test
    public void ShouldPrintElements(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        assertThat(linkedList.size()).isEqualTo(5);

        for(Integer element : linkedList){
            System.out.println(element);
        }
    }

    @Test
    public void shouldRemoveElement(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        assertThat(linkedList.size()).isEqualTo(5);

        Iterator<Integer> iter = linkedList.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.remove();

        assertThat(linkedList.size()).isEqualTo(4);
        for(Integer element : linkedList){
            System.out.println(element);
        }
    }

    @Test
    public void shouldThrowException(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        assertThat(linkedList.size()).isEqualTo(5);

        boolean exceptionThrown = false;
        try{
            Iterator<Integer> iter = linkedList.iterator();
            iter.remove();
        }
        catch (IllegalStateException e){
            exceptionThrown = true;
        }

        assertThat(exceptionThrown).isTrue();
    }

    @Test
    public void shouldRemoveFirstElement(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        assertThat(linkedList.size()).isEqualTo(5);

        Iterator<Integer> iter = linkedList.iterator();
        iter.next();
        iter.remove();

        for(Integer element : linkedList){
            System.out.println(element);
        }
    }

    @Test
    public void shouldRemoveLast(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertThat(linkedList.size()).isEqualTo(3);

        Iterator<Integer> iter = linkedList.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.remove();
        assertThat(linkedList.size()).isEqualTo(2);

        for(Integer element : linkedList){
            System.out.println(element);
        }
    }

    @Test
    public void shouldThrowNoSuchElementException(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertThat(linkedList.size()).isEqualTo(3);
        boolean exceptionThrown = false;
        try{
            Iterator<Integer> iter = linkedList.iterator();
            iter.next();
            iter.next();
            iter.next();
            iter.next();
        }
        catch (NoSuchElementException e){
            exceptionThrown = true;
        }

        assertThat(exceptionThrown).isTrue();
    }

    @Test
    public void shouldHasNextReturnFalse(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        Iterator<Integer> iter = linkedList.iterator();
        assertThat(iter.hasNext()).isFalse();
    }

    @Test
    public void shouldThrowNoSuchElementExceptionForEmptyList(){
        LinkedList<Integer> linkedList = new LinkedList<>();

        boolean exceptionThrown = false;
        try{
            linkedList.remove();
        }
        catch(NoSuchElementException e){
            exceptionThrown = true;
        }

        assertThat(exceptionThrown).isTrue();
    }

    @Test
    public void shouldRemovePassedElement(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertThat(linkedList.size()).isEqualTo(3);


        assertThat(linkedList.remove((Integer) 2)).isTrue();
        for(Integer element : linkedList){
            System.out.println(element);
        }
    }

    @Test
    public void shouldReturnFalseOnNonExistingElementRemoval(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertThat(linkedList.size()).isEqualTo(3);


        assertThat(linkedList.remove((Integer) 10)).isFalse();
        for(Integer element : linkedList){
            System.out.println(element);
        }
    }

    @Test
    public void shouldReturnTrueContainsAll(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertThat(linkedList.size()).isEqualTo(3);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(1);
        linkedList2.add(2);
        linkedList2.add(3);
        assertThat(linkedList2.size()).isEqualTo(3);

        assertThat(linkedList.containsAll(linkedList2)).isTrue();
    }

    @Test
    public void shuldReturnFalseContainsAll(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertThat(linkedList.size()).isEqualTo(3);

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(1);
        linkedList2.add(4);
        assertThat(linkedList2.size()).isEqualTo(2);

        assertThat(linkedList.containsAll(linkedList2)).isFalse();
    }

    @Test
    public void shouldConvertListToArray(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertThat(linkedList.size()).isEqualTo(3);

        Object[] array = linkedList.toArray();
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    @Test
    public void shouldClearList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertThat(linkedList.size()).isEqualTo(3);

        linkedList.clear();
        assertThat(linkedList.size()).isEqualTo(0);
        linkedList.add(6);

        for(Integer element : linkedList){
            System.out.println(element);
        }

        System.out.println(linkedList.getFirst());
    }
}
