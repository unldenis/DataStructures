import com.github.unldenis.data.*;
import org.junit.jupiter.api.*;

public class SinglyLinkedListTest {

    private List<Integer> gen() {
        SinglyLinkedList<Integer> dA = new SinglyLinkedList<>();
        for(int j = 0; j < 20; j++) {
            dA.add(j);
        }
        return dA;
    }

    @Test
    void iterateAndsize() {
        List<Integer> dA = gen();
        for(int e: dA) {
            System.out.println(e);
        }
        assert dA.size() == 20;
    }

    @Test
    void removeIndex() {
        List<Integer> dA = gen();
        dA.remove(1);
        assert dA.get(1) == 2;
    }

    @Test
    void removeElement() {
        List<Integer> dA = gen();
        dA.remove(18);
        assert dA.get(18) == 19;
    }
}
