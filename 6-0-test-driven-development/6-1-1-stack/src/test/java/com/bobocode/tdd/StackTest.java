package com.bobocode.tdd;

import org.junit.jupiter.api.Test;

import com.bobocode.tdd.exception.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {

    private Stack<Integer> stack = new LinkedStack<>();

    @Test
    void testPush() {
        stack.push(1);

        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    void testPop() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void testPushElements() {
        stack = LinkedStack.of(2, 3, 4);

        stack.push(1);

        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    void testPopElements() {
        stack = LinkedStack.of(5, 6, 7);

        stack.pop();
        stack.push(1);
        int lastElement = stack.pop();

        assertThat(lastElement).isEqualTo(1);
    }

    @Test
    void testSize() {
        stack = LinkedStack.of(5, 6, 7);

        assertThat(stack.size()).isEqualTo(3);
    }

    @Test
    void testSizeOnEmptyStack() {
        assertThat(stack.size()).isEqualTo(0);
    }

    @Test
    void testIsEmpty() {
        stack = LinkedStack.of(5, 6, 7);

        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    void testIsEmptyOnEmptyStack() {
        assertThat(stack.isEmpty()).isTrue();
    }
}
