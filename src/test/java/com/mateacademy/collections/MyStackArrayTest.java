package com.mateacademy.collections;

import com.mateacademy.interfaces.MyStack;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackArrayTest {
    private MyStack<String> myStack = new MyStackArray<>();

    @Test
    public void isEmpty() {
        assertEquals(myStack.size() == 0, myStack.isEmpty());
        myStack.push("1");
        myStack.push("2");
        assertEquals(myStack.size() == 0, myStack.isEmpty());
    }

    @Test
    public void push() {
        myStack.push("Test");
        String expectedItem = "Test";
        int expectedSize = 1;
        assertEquals(myStack.peek(), expectedItem);
        assertEquals(myStack.size(), expectedSize);
    }

    @Test
    public void remove() {
        myStack.push("Test");
        myStack.remove();
        int expectedSize = 0;
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void clear() {
        myStack.push("Test");
        myStack.push("Test2");
        myStack.clear();
        int expectedSize = 0;
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void size() {
        myStack.push("Test");
        myStack.push("Test2");
        int expectedSize = 2;
        assertEquals(expectedSize, myStack.size());
        myStack.clear();
        expectedSize = 0;
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void peek() {
        myStack.push("Test");
        myStack.push("Test2");
        String expectedObject = "Test2";
        int expectedSize = 2;
        assertEquals(expectedObject, myStack.peek());
        assertEquals(expectedSize, myStack.size());
    }

    @Test
    public void pop() {
        myStack.push("Test");
        myStack.push("Test2");
        String expectedObject = "Test2";
        int expectedSize = 1;
        assertEquals(expectedObject, myStack.pop());
        assertEquals(expectedSize, myStack.size());
    }
}
