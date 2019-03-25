package com.mateacademy.collections;

import com.mateacademy.interfaces.MyStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyStackArrayTest {
    private static final int NEGATIVE_ILLEGAL_CAPACITY = -5;
    private static final String FIRST_TEST_ITEM = "first";
    private static final String SECOND_TEST_ITEM = "second";
    private static final String THIRD_TEST_ITEM = "third";

    private MyStack<String> myStack;

    @Before
    public void initStack() {
        myStack = new MyStackArray<>();
        myStack.push(FIRST_TEST_ITEM);
        myStack.push(SECOND_TEST_ITEM);
        myStack.push(THIRD_TEST_ITEM);
    }

    @Test
    public void shouldReturnTrueIfStackIsEmptyOrFalseIfIsNotEmpty() {
        assertFalse(myStack.isEmpty());
        myStack.clear();
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void shouldPushElementToStack() {
        myStack.push("Test");
        String expectedItem = "Test";
        int expectedSize = 4;
        assertEquals(myStack.peek(), expectedItem);
        assertEquals(myStack.size(), expectedSize);
    }

    @Test
    public void shouldRemoveElementFromStack() {
        myStack.remove();
        int expectedSize = 2;
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void shouldClearElementsOfStack() {
        myStack.clear();
        int expectedSize = 0;
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void shouldReturnSizeOfStack() {
        int expectedSize = 3;
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void shouldPeekElementFromStack() {
        String expectedObject = "third";
        int expectedSize = 3;
        assertEquals(expectedObject, myStack.peek());
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void shouldPopElementFromStack() {
        String expectedObject = "third";
        int expectedSize = 2;
        assertEquals(expectedObject, myStack.pop());
        assertEquals(expectedSize, myStack.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnIllegalConstructorParameter() {
        MyStack<Integer> stack = new MyStackArray<>(NEGATIVE_ILLEGAL_CAPACITY);
    }
}
