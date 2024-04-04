import org.example.LinkedList;
import org.junit.jupiter.api.Test;

public class TestLinkedList {

    @Test
    public void ShouldAddOneValueToList(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        System.out.println(linkedList.toString());
    }

    @Test
    public void ShouldAddTwoValuesToList(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        System.out.println(linkedList.toString());
    }

    @Test
    public void ShouldAddThreeValuesToList(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList.toString());
    }

    @Test
    public void ShouldAddFourValuesToList(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList.toString());
    }

}
