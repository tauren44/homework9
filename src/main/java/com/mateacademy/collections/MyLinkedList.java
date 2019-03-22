package com.mateacademy.collections;

import com.mateacademy.interfaces.MyList;

public class MyLinkedList<E> implements MyList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList() {
        first = new Node<>(null, null, null);
        last = first;
    }

    public void add(E e) {
        if (first.item == null) {
            first.prev = last;
            first.next = last;
            first.item = e;
        } else if (last.item == null) {
            last.prev = first;
            last.next = first;
            last.item = e;
        } else {
            Node<E> node = new Node<>(last.prev, e, last);
            last.prev = node;
            node.prev.next = node;
        }
        size++;
    }

    public void remove(int index) {
        Node<E> target = getNodeByIndex(index);
        Node<E> prev = target.prev;
        Node<E> next = target.next;
        if (prev == null) {
            first = target.next;
        } else if (next == null) {
            last = target.prev;
        } else {
            prev.next = next;
            next.prev = prev;
            target.next = null;
            target.prev = null;
        }
        target.item = null;
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            remove(0);
        }
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        Node<E> target = getNodeByIndex(index);
        return target.item;
    }

    private Node<E> getNodeByIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> target = first;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target;
    }
}
