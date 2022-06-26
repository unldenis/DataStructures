package com.github.unldenis.data;

import java.util.*;

public class Queue<T> {

    private final SinglyLinkedList<T> linkedList = new SinglyLinkedList<>();

    public Queue() {
    }

    public Queue(T first) {
        add(first);
    }

    public int size() {
        return linkedList.size();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public void add(T element) {
        linkedList.add(element);
    }

    public T poll() {
        if(isEmpty())
            throw new NoSuchElementException();

        SinglyLinkedList.Node<T> head = linkedList.head;
        T tmp = head.element;
        linkedList.head = head.next;
        linkedList.size--;
        return tmp;
    }

    public T peek() {
        if(isEmpty())
            throw new NoSuchElementException();

        return linkedList.head.element;
    }


}
