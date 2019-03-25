package com.mateacademy.collections;

import com.mateacademy.interfaces.MyList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {
    private static final int FIRST_TEST_ELEMENT = 10;
    private static final int SECOND_TEST_ELEMENT = 20;
    private static final int POSITIVE_ILLEGAL_INDEX = 50;
    private static final int NEGATIVE_ILLEGAL_INDEX = -1;

    private MyList<Integer> myList;

    @Before
    public void listInit() {
        myList = new MyLinkedList<>();
        myList.add(FIRST_TEST_ELEMENT);
        myList.add(SECOND_TEST_ELEMENT);
    }

    @Test
    public void shouldAddElementToCollection() {
        int expectedSize = 3;
        Integer expectedObject = 10;
        myList.add(10);
        assertEquals(expectedSize, myList.size());
        assertEquals(expectedObject, myList.get(0));
    }

    @Test
    public void shouldRemoveElementByIndex() {
        int expectedSize = 1;
        myList.remove(0);
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void shouldClearCollection() {
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
        Integer expectedObject = 20;
        assertEquals(myList.get(1), expectedObject);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnGetWithIllegalIndexParameter() {
        myList.get(POSITIVE_ILLEGAL_INDEX);
        myList.get(NEGATIVE_ILLEGAL_INDEX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnRemoveWithIllegalIndexParameter() {
        myList.remove(POSITIVE_ILLEGAL_INDEX);
        myList.remove(NEGATIVE_ILLEGAL_INDEX);
    }
}
