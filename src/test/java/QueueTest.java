import com.github.unldenis.data.*;
import org.junit.jupiter.api.*;

public class QueueTest {

    @Test
    void queue01() {
        Queue<Integer> queue = new Queue<>();

        queue.add(0);
        queue.add(1);
        queue.add(3);

        while(!queue.isEmpty())
            System.out.println(queue.poll());

        assert queue.isEmpty();

    }
}
