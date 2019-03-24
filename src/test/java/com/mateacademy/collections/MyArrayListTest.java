package com.mateacademy.collections;

import com.mateacademy.interfaces.MyList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyArrayListTest {
    private MyList<String> myList;

    @Before
    public void initCollection() {
        myList = new MyArrayList<>();
        myList.add("first");
        myList.add("second");
    }

    @After
    public void clearCollection() {
        myList = null;
    }

    @Test
    public void addElement() {
        myList.add("third");
        String expected = "third";
        assertEquals(myList.get(2), expected);
    }

    @Test
    public void removeElementByIndex() {
        int expectedSize = 1;
        myList.remove(0);
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void clearAllElements() {
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
        String expectedObject = "first";
        assertEquals(myList.get(0), expectedObject);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementByIndex_IllegalIndex_ExceptionThrown() {
        myList.get(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeElementByIndex_IllegalIndex_ExceptionThrown() {
        myList.remove(6);
    }
}
