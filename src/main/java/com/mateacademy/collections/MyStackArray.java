package com.mateacademy.collections;

import com.mateacademy.interfaces.MyStack;

public class MyStackArray<E> implements MyStack<E> {
    private final int DEFAULT_CAPACITY = 10;
    private final int CUT_RATE = 3;
    private Object[] array;
    private int size;

    public MyStackArray(int capacity) {
        if (capacity >= 0) {
            array = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    public MyStackArray() {
        array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void push(E item) {
        if (size == 0) {
            resizeArray(DEFAULT_CAPACITY);
        }
        if (size == array.length - 1) {
            resizeArray(array.length * 2);
        }
        array[size++] = item;
    }

    @Override
    public void remove() {

        if (!isEmpty()) {
            array[size--] = null;
            if (array.length > DEFAULT_CAPACITY && size < array.length / CUT_RATE) {
                resizeArray(array.length / 2);
            }
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("/unchecked/")
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[size - 1];
    }

    @SuppressWarnings("/unchecked/")
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[--size];
    }

    private void resizeArray(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
