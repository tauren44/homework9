package com.mateacademy.collections;

import com.mateacademy.interfaces.MyStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyStackArrayTest {
    private MyStack<String> myStack;

    @Before
    public void initStack() {
        myStack = new MyStackArray<>();
        myStack.push("first");
        myStack.push("second");
        myStack.push("third");
    }

    @After
    public void clearStack() {
        myStack = null;
    }

    @Test
    public void isStackEmpty() {
        assertEquals(myStack.size() == 0, myStack.isEmpty());
        myStack.clear();
        assertEquals(myStack.size() == 0, myStack.isEmpty());
    }

    @Test
    public void pushElementToStack() {
        myStack.push("Test");
        String expectedItem = "Test";
        int expectedSize = 4;
        assertEquals(myStack.peek(), expectedItem);
        assertEquals(myStack.size(), expectedSize);
    }

    @Test
    public void removeElementFromStack() {
        myStack.remove();
        int expectedSize = 2;
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void clearElements() {
        myStack.clear();
        int expectedSize = 0;
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void returnSizeOfStack() {
        int expectedSize = 3;
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void peekElementFromStack() {
        String expectedObject = "third";
        int expectedSize = 3;
        assertEquals(expectedObject, myStack.peek());
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void popElementFromStack() {
        String expectedObject = "third";
        int expectedSize = 2;
        assertEquals(expectedObject, myStack.pop());
        assertEquals(expectedSize, myStack.size());
    }
}
