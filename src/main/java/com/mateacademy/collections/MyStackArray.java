package com.mateacademy.collections;

import com.mateacademy.interfaces.MyStack;

public class MyStackArray<E> implements MyStack<E> {
    private final int DEFAULT_CAPACITY = 10;
    private final int CUT_RATE = 3;
    private Object[] array;
    private int size;


    public MyStackArray(int capacity) {
        if (capacity > DEFAULT_CAPACITY) {
            array = new Object[capacity];
        } else if (capacity >= 0) {
            array = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);
        }
    }

    public MyStackArray() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void push(E item) {
        if (size == array.length - 1) {
            resizeArray(array.length * 2);
        }
        array[size++] = item;
    }

    public void remove() {

        if (!isEmpty()) {
            array[size--] = null;
            if (array.length > DEFAULT_CAPACITY && size < array.length / CUT_RATE) {
                resizeArray(array.length / 2);
            }
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("/unchecked/")
    public E peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return (E) array[size-1];
    }

    @SuppressWarnings("/unchecked/")
    public E pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
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
