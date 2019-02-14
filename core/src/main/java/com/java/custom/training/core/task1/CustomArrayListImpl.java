package com.java.custom.training.core.task1;


import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class CustomArrayListImpl<T> implements CustomArrayList<T> {
    private T[] array;
    private int length = 0;
    private static final int DEFAULT_LENGTH = 10;

    @SuppressWarnings("unchecked")
    public CustomArrayListImpl() {
        this.array = (T[])new Object[DEFAULT_LENGTH];
    }

    @SuppressWarnings("unchecked")
    public CustomArrayListImpl(int capacity){
        this.array = (T[]) new Object[capacity];
    }

    @Override
    public boolean add(T element) {
        if(this.length >= this.array.length){
            this.array = Arrays.copyOf(array, array.length*2);
        }
        this.array[this.length++] = element;
        return true;
    }

    @Override
    public T get(int index) {
        if(index >= this.array.length){
            throw new ArrayIndexOutOfBoundsException("Wrong index");
        }
        return this.array[index];
    }

    @Override
    public void clear() {
        Arrays.fill(this.array, null);
    }

    @Override
    public int size() {
        int size = 0;
        for (T element: this.array) {
            if(element != null){
                size++;
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object element) {
        return ArrayUtils.contains(array, element);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.array, this.size()));
    }

    @Override
    public boolean remove(Object element) {
        if(contains(element)){
            int indexToRemove = ArrayUtils.indexOf(this.array, element);
            if(indexToRemove != 0){
                this.array = ArrayUtils.addAll(Arrays.copyOfRange(this.array, 0, indexToRemove),
                        Arrays.copyOfRange(this.array, indexToRemove + 1, this.length));
            }
            else{
                this.array = Arrays.copyOfRange(this.array, 1, this.length);
            }

            return true;
        }
        return false;
    }

}
