package com.mateacademy.collections;

import com.mateacademy.interfaces.MyMap;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class MyHashMapTest {
    private static final int FIRST_KEY = 1;
    private static final int SECOND_KEY = 2;
    private static final int THIRD_KEY = 3;
    private static final String FIRST_VALUE = "first";
    private static final String SECOND_VALUE = "second";
    private static final String THIRD_VALUE = "third";
    private static final int POSITIVE_ILLEGAL_KEY = 500;
    private static final int NEGATIVE_ILLEGAL_KEY = -1;

    private MyMap<Integer, String> myMap;

    @Before
    public void initMap() {
        myMap = new MyHashMap<>();
        myMap.put(FIRST_KEY, FIRST_VALUE);
        myMap.put(SECOND_KEY, SECOND_VALUE);
        myMap.put(THIRD_KEY, THIRD_VALUE);
    }

    @Test
    public void shouldAddElementToMap() {
        myMap.put(4, "test");
        int expectedSize = 4;
        String expectedValue = "test";
        assertEquals(myMap.size(), expectedSize);
        assertEquals(myMap.get(4), expectedValue);
    }

    @Test
    public void shouldRemoveElementFromMap() {
        int expectedSize = 2;
        myMap.remove(1);
        assertEquals(expectedSize, myMap.size());
    }

    @Test
    public void shouldReturnElementByKey() {
        String expectedValue = "third";
        assertEquals(myMap.get(3), expectedValue);
    }

    @Test
    public void shouldReturnSizeOfMap() {
        int expectedSize = 3;
        assertEquals(expectedSize, myMap.size());
    }

    @Test
    public void shouldClearElementsOfMap() {
        myMap.clear();
        int expectedSize = 0;
        assertEquals(expectedSize, myMap.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementExceptionIfNoKeyExists() {
        myMap.get(POSITIVE_ILLEGAL_KEY);
        myMap.get(NEGATIVE_ILLEGAL_KEY);
    }
}
