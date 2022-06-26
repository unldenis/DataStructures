package com.github.unldenis.data;

public interface List<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    void set(int index, T element);

    T get(int index);

    void add(T element);

    void remove(T element);

    void remove(int index);

    void clear();

}
