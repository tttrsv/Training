package com.java.custom.training.core.task1;


public interface CustomArrayList<T> {

    boolean add(T element);

    T get(int index);

    void clear();

    int size();

    boolean isEmpty();

    boolean contains(Object element);

    boolean remove(Object element);
}
