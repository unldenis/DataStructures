package com.github.unldenis.data;

import java.util.*;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements List<T> {

    private T[] array;
    private int size;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        array = (T[]) new Object[capacity];
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
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        array[index] = element;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public void add(T element) {
        if(size == array.length) {
            T[] newA = (T[]) new Object[size * 2];
            System.arraycopy(array, 0, newA, 0, array.length);
            array = newA;
        }
        array[size++] = element;
    }

    @Override
    public void remove(T element) {
        int index = -1;
        for(int j = 0; j < size(); j++) {
            if(array[j].equals(element)) {
                index = j;
                break;
            }
        }
        remove(index);
    }

    @Override
    public void remove(int index) {
        if (size() - 1 - index < 0)
            throw new IndexOutOfBoundsException();
        System.arraycopy(array, index + 1, array, index, size() - 1 - index);
        size--;
    }

    @Override
    public void clear() {
        for(int j = 0; j < size(); j++) {
            array[j] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        if (array == null)
            return "null";

        int iMax = size() - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(array[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }
}
