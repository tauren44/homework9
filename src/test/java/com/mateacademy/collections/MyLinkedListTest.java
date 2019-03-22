package com.mateacademy.collections;

import com.mateacademy.interfaces.MyList;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {
    private MyList<Integer> myList = new MyLinkedList<>();

    @Test
    public void add() {
        int expectedSize = 1;
        Integer expectedObject = 5;
        myList.add(5);
        assertEquals(expectedSize, myList.size());
        assertEquals(expectedObject, myList.get(0));
    }

    @Test
    public void remove() {
        int expectedSize = 0;
        myList.add(12);
        myList.remove(0);
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void clear() {
        myList.add(13);
        myList.clear();
        int expectedSize = 0;
        assertEquals(myList.size(), expectedSize);
    }

    @Test
    public void size() {
        myList.add(1);
        myList.add(2);
        myList.add(3);
        int expectedSize = 3;
        assertEquals(myList.size(), expectedSize);
    }

    @Test
    public void get() {
        myList.add(156);
        Integer expectedObject = 156;
        assertEquals(myList.get(0), expectedObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        myList.get(0);
    }
}
