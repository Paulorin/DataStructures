package tmp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestJavaCollections {
    @Test
    public void ShouldGetSizeOfAnEmptyJavaList(){
        List<Object> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }

    @Test
    public void test(){

    }
}
