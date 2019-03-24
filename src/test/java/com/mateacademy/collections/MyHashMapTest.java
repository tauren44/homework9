package com.mateacademy.collections;

import com.mateacademy.interfaces.MyMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class MyHashMapTest {
    private MyMap<Integer, String> myMap;

    @Before
    public void initMap() {
        myMap = new MyHashMap<>();
        myMap.put(1, "first");
        myMap.put(2, "second");
        myMap.put(3, "third");
    }

    @After
    public void clearMap() {
        myMap = null;
    }

    @Test
    public void putElementToMap() {
        myMap.put(4, "test");
        int expectedSize = 4;
        String expectedValue = "test";
        assertEquals(myMap.size(), expectedSize);
        assertEquals(myMap.get(4), expectedValue);
    }

    @Test
    public void removeElementFromMap() {
        int expectedSize = 2;
        myMap.remove(1);
        assertEquals(expectedSize, myMap.size());
    }

    @Test
    public void getElementByKey() {
        String expectedValue = "third";
        assertEquals(myMap.get(3), expectedValue);
    }

    @Test
    public void returnSizeOfMap() {
        int expectedSize = 3;
        assertEquals(expectedSize, myMap.size());
    }

    @Test
    public void clearElements() {
        myMap.clear();
        int expectedSize = 0;
        assertEquals(expectedSize, myMap.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void getElementByKey_IllegalKey_ExceptionThrown() {
        myMap.get(56);
    }
}
