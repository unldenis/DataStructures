package com.github.unldenis.data;

import java.util.*;

public class SinglyLinkedList<T> implements List<T> {

    protected int size;
    protected Node<T> head;
    protected Node<T> tail;

    public SinglyLinkedList() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void set(int index, T element) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node<T> node = head;

        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        node.element = element;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Iterator<T> it = iterator();
        T val = null;
        for(int j = 0; j <= index; j++) {
            val = it.next();
        }

        return val;
    }

    @Override
    public void add(T element) {
        if(isEmpty()) {
            head = new Node<>(element, null);
        } else if (size() == 1) {
            tail = new Node<>(element, null);
            head.next = tail;
        } else {
            Node<T> last = new Node<>(element, null);
            tail.next = last;
            tail = last;
        }
        size++;
    }

    @Override
    public void remove(T element) {
        for(Iterator<T> it = iterator(); it.hasNext(); ) {
            if(it.next().equals(element)) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Iterator<T> it = iterator();
        int j = 0;
        while(j <= index) {
            it.next();
            j++;
        }
        it.remove();
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = head;
            private Node<T> previous;
            private Node<T> previous2;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if(current == null)
                    throw new NoSuchElementException();
                T element = current.element;
                previous2 = previous;
                previous = current;
                current = current.next;
                return element;
            }

            @Override
            public void remove() {
                if(previous == null)
                    throw new IllegalStateException();

                if(previous2 == null) {
                    head = current;
                } else {
                    previous2.next = current;
                    previous = previous2;
                }
                size--;
            }
        };
    }

    protected static class Node<T> {
        protected T element;
        protected Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }
}
