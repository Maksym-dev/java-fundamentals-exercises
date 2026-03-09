package com.bobocode.tdd;

import com.bobocode.tdd.exception.EmptyStackException;

import java.util.Objects;
import java.util.stream.Stream;

public class LinkedStack<T> implements Stack<T> {

    private Node<T> head;
    private int size = 0;

    public static <T> LinkedStack<T> of(T... elements) {
        LinkedStack<T> linkedStack = new LinkedStack<>();
        Stream.of(elements).forEach(linkedStack::push);
        return linkedStack;
    }

    @Override
    public void push(T element) {
        Objects.requireNonNull(element);
        Node<T> newNode = new Node<>(element);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }
    
    @Override
    public T pop() {
        if (head != null) {
            size--;
            T element = head.element;
            this.head = head.next;
            return element;
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        T element;
        Node<T> next;

        private Node(T element) {
            this.element = element;
        }
    }
}
