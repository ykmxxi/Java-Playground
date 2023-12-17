package chap7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackQueueTest {

    @DisplayName("스택 자료구조는 LIFO 구조")
    @Test
    void 스택_자료구조() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.peek()).isEqualTo(2); // peek()은 가장 위에 존재하는 값만 조회 하고 제거하지는 않음
        assertThat(stack.pop()).isEqualTo(2);
    }

    @DisplayName("큐 자료구조는 FIFO 구조")
    @Test
    void 큐_자료구조() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        assertThat(queue.poll()).isEqualTo(1);
        assertThat(queue.peek()).isEqualTo(2);
        assertThat(queue.poll()).isEqualTo(2);
    }

}
