package com.mateacademy.collections;

import com.mateacademy.interfaces.MyMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {
    MyMap<Integer, String> myMap = new MyHashMap<>();

    @Test
    public void put() {
        myMap.put(1, "one");
        int expectedSize = 1;
        String expectedValue = "one";
        assertEquals(myMap.size(), expectedSize);
        assertEquals(myMap.get(1), expectedValue);
    }

    @Test
    public void remove() {
        myMap.put(1, "one");
        myMap.put(2, "two");
        int expectedSize = 1;
        myMap.remove(1);
        assertEquals(expectedSize, myMap.size());
    }

    @Test
    public void get() {
        myMap.put(15, "test");
        String expectedValue = "test";
        assertEquals(myMap.get(15), expectedValue);
    }

    @Test
    public void size() {
        myMap.put(1, "one");
        myMap.put(2, "two");
        int expectedSize = 2;
        assertEquals(expectedSize, myMap.size());
    }

    @Test
    public void clear() {
        myMap.put(1, "one");
        myMap.put(2, "two");
        myMap.clear();
        int expectedSize = 0;
        assertEquals(expectedSize, myMap.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        myMap.get(56);
        myMap.get(0);
    }
}
