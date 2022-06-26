package com.github.unldenis.data;

import java.util.*;

public class Stack<T> {

    private final SinglyLinkedList<T> linkedList = new SinglyLinkedList<>();

    public Stack() {
    }

    public Stack(T first) {
        offer(first);
    }

    public int size() {
        return linkedList.size();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public void offer(T element) {
        linkedList.add(element);
    }

    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();

        T tmp = null;
        Iterator<T> it;
        for(it = linkedList.iterator(); it.hasNext(); ) {
            tmp = it.next();
        }
        it.remove();
        return tmp;
    }

    public T top() {
        if(isEmpty())
            throw new EmptyStackException();
        return linkedList.tail.element;
    }
}
