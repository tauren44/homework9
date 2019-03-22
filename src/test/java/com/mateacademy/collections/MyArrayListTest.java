package com.mateacademy.collections;

import com.mateacademy.interfaces.MyList;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {
    private MyList<String> myList = new MyArrayList<>();

    @Test
    public void add() {
        int expectedSize = 1;
        String expectedObject = "Test";
        myList.add("Test");
        assertEquals(expectedSize, myList.size());
        assertEquals(expectedObject, myList.get(0));
    }

    @Test
    public void remove() {
        int expectedSize = 0;
        myList.add("Test");
        myList.remove(0);
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void clear() {
        myList.add("1");
        myList.clear();
        int expectedSize = 0;
        assertEquals(myList.size(), expectedSize);
    }

    @Test
    public void size() {
        myList.add("1");
        myList.add("2");
        int expectedSize = 2;
        assertEquals(myList.size(), expectedSize);
    }

    @Test
    public void get() {
        myList.add("test");
        String expectedObject = "test";
        assertEquals(myList.get(0), expectedObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        myList.get(0);
    }
}
