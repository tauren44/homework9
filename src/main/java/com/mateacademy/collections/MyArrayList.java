package com.mateacademy.collections;

import com.mateacademy.interfaces.MyList;

public class MyArrayList<E> implements MyList<E> {

    private final int DEFAULT_CAPACITY = 10;
    private final int CUT_RATE = 3;
    private Object[] array;
    private int size;

    /**
     * If no capacity chosen, it will be default
     */
    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    /**
     * If capacity is more than default, method will create list with chosen capacity.
     * If capacity is from 0 to 10, method will create list with default capacity
     */
    public MyArrayList(int capacity) {
        if (capacity > DEFAULT_CAPACITY) {
            array = new Object[capacity];
        } else if (capacity >= 0) {
            array = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);
        }
    }

    /**
     * Before adding a new item, we ensure that array has enough size.
     * If it has not, we double the size of array
     */
    public void add(E item) {
        if (size == array.length - 1) {
            resizeArray(array.length * 2);
        }
        array[size++] = item;
    }

    /**
     * Method is moving items left for 1 index, then last item of array sets to null
     */
    public void remove(int index) {
        if (size - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        array[size] = null;
        size--;
        if (array.length > DEFAULT_CAPACITY && size < array.length / CUT_RATE) {
            resizeArray(array.length / 2);
        }
    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
        resizeArray(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("/uncheked/")
    public E get(int index) {

        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    private void resizeArray(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
