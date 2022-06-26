import com.github.unldenis.data.*;
import org.junit.jupiter.api.*;

public class StackTest {

    @Test
    void stack01() {
        Stack<Integer> stack = new Stack<>();

        stack.offer(0);
        stack.offer(1);
        stack.offer(3);

        while(!stack.isEmpty())
            System.out.println(stack.pop());

        assert stack.isEmpty();

    }
}
