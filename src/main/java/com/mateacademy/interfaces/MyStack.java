package com.mateacademy.interfaces;

public interface MyStack<E> {
    void push(E item);
    void remove();
    void clear();
    boolean isEmpty();
    int size();
    E peek();
    E pop();
}
