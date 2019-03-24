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
     * Method will create list with chosen capacity.
     */
    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            array = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    /**
     * Before adding a new item, we ensure that array has enough size.
     * If it has not, we double the size of array
     */
    @Override
    public void add(E item) {
        if (array.length == 0) {
            resizeArray(DEFAULT_CAPACITY);
        }
        if (size == array.length - 1) {
            resizeArray(array.length * 2);
        }
        array[size++] = item;
    }

    /**
     * Method is moving items left for 1 index, then last item of array sets to null
     */
    @Override
    public void remove(int index) {
        MyListUtil.checkRange(index, size);
        if (size - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        array[size] = null;
        size--;
        if (array.length > DEFAULT_CAPACITY && size < array.length / CUT_RATE) {
            resizeArray(array.length / 2);
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
        resizeArray(DEFAULT_CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("/uncheked/")
    public E get(int index) {
        MyListUtil.checkRange(index, size);
        return (E) array[index];
    }

    private void resizeArray(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
