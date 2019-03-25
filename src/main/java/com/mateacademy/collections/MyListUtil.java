package com.mateacademy.collections;

public class MyListUtil {
    public static void checkRange(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
    }
}
