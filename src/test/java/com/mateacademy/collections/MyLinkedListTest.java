package com.mateacademy.collections;

import com.mateacademy.interfaces.MyList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {
    private MyList<Integer> myList;

    @Before
    public void listInit() {
        myList = new MyLinkedList<>();
        myList.add(10);
        myList.add(20);
    }

    @After
    public void clearList() {
        myList = null;
    }

    @Test
    public void addElement() {
        int expectedSize = 3;
        Integer expectedObject = 10;
        myList.add(10);
        assertEquals(expectedSize, myList.size());
        assertEquals(expectedObject, myList.get(0));
    }

    @Test
    public void removeElementByIndex() {
        int expectedSize = 1;
        myList.remove(0);
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void clearCollection() {
        myList.clear();
        int expectedSize = 0;
        assertEquals(myList.size(), expectedSize);
    }

    @Test
    public void returnSizeOfCollection() {
        int expectedSize = 2;
        assertEquals(myList.size(), expectedSize);
    }

    @Test
    public void getElementByIndex() {
        Integer expectedObject = 20;
        assertEquals(myList.get(1), expectedObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementByIndex_IllegalIndex_ExceptionThrown() {
        myList.get(30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeElementByIndex_IllegalIndex_ExceptionThrown() {
        myList.remove(30);
    }
}
