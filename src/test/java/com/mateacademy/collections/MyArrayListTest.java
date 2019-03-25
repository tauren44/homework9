package com.mateacademy.collections;

import com.mateacademy.interfaces.MyList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyArrayListTest {
    private static final int POSITIVE_ILLEGAL_INDEX = 50;
    private static final int NEGATIVE_ILLEGAL_INDEX = -1;
    private static final String FIRST_TEST_ITEM = "first";
    private static final String SECOND_TEST_ITEM = "second";

    private MyList<String> myList;

    @Before
    public void initCollection() {
        myList = new MyArrayList<>();
        myList.add(FIRST_TEST_ITEM);
        myList.add(SECOND_TEST_ITEM);
    }

    @Test
    public void shouldAddElement() {
        myList.add("third");
        String expected = "third";
        assertEquals(myList.get(2), expected);
    }

    @Test
    public void shouldRemoveElementByIndex() {
        int expectedSize = 1;
        myList.remove(0);
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void shouldClearAllElements() {
        myList.clear();
        int expectedSize = 0;
        assertEquals(myList.size(), expectedSize);
    }

    @Test
    public void shouldReturnSizeOfCollection() {
        int expectedSize = 2;
        assertEquals(myList.size(), expectedSize);
    }

    @Test
    public void shouldReturnElementByIndex() {
        String expectedObject = "first";
        assertEquals(myList.get(0), expectedObject);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnGettingElementByIndex() {
        myList.get(POSITIVE_ILLEGAL_INDEX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnRemovingElementByIndex() {
        myList.remove(POSITIVE_ILLEGAL_INDEX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnIllegalConstructorParameter() {
        MyList<Object> list = new MyArrayList<>(NEGATIVE_ILLEGAL_INDEX);
    }
}
