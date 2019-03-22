package com.mateacademy.collections;

import com.mateacademy.interfaces.MyMap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private Node<K, V>[] hashTable;
    private int size;
    private static final float LOADFACTOR = 0.75f;
    private static final int DEFAULT_CAPACITY = 16;
    private float threshold;

    @SuppressWarnings("/unchecked/")
    public MyHashMap() {
        hashTable = new Node[DEFAULT_CAPACITY];
        threshold = hashTable.length * LOADFACTOR;
    }

    public boolean put(final K key, final V value) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            resize();
        }

        Node<K, V> node = new Node<>(key, value);
        int index = hash(key);

        if (hashTable[index] == null) {
            return add(index, node);
        }

        List<Node<K, V>> nodeList = hashTable[index].nodes;

        for (Node<K, V> n : nodeList) {
            if (replaceKeyWithNewValue(n, node, value) ||
                    makeCollision(n, node, nodeList)) {
                return true;
            }
        }
        return false;
    }

    private boolean add(int index, Node<K, V> node) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].nodes.add(node);
        size++;
        return true;
    }

    private boolean replaceKeyWithNewValue(final Node<K, V> nodeFromList,
                                           final Node<K, V> newNode,
                                           final V value) {
        if (newNode.key.equals(nodeFromList.key) &&
                !newNode.value.equals(nodeFromList.value)) {
            nodeFromList.value = value;
            return true;
        }
        return false;
    }

    private boolean makeCollision(Node<K, V> nodeFromList,
                                  Node<K, V> newNode,
                                  List<Node<K, V>> nodeList) {
        if (newNode.hashCode() == nodeFromList.hashCode() &&
                !Objects.equals(newNode.key, nodeFromList.key) &&
                !Objects.equals(newNode.value, nodeFromList.value)
        ) {
            nodeList.add(newNode);
            size++;
            return true;
        }
        return false;
    }

    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int arrayCounter;
            int valueCounter;
            Iterator<Node<K, V>> subIterator = null;

            public boolean hasNext() {
                if (valueCounter == size) {
                    return false;
                }
                if (subIterator == null || !subIterator.hasNext()) {
                    if (moveToNextCell()) {
                        subIterator = hashTable[arrayCounter].nodes.iterator();
                    } else {
                        return false;
                    }
                }
                return subIterator.hasNext();
            }

            private boolean moveToNextCell() {
                arrayCounter++;
                while (arrayCounter < hashTable.length && hashTable[arrayCounter] == null) {
                    arrayCounter++;
                }
                return arrayCounter < hashTable.length && hashTable[arrayCounter] != null;
            }

            public V next() {
                valueCounter++;
                return subIterator.next().value;
            }

            @Override
            public void remove() {
            }
        };
    }


    private class Node<K, V> {
        private List<Node<K, V>> nodes;
        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<>();
        }
    }

    public boolean remove(K key) {
        int index = hash(key);

        if (hashTable[index] == null) {
            return false;
        }

        if (hashTable[index].nodes.size() == 1) {
            hashTable[index].nodes = null;
            size--;
            return true;
        }

        List<Node<K, V>> nodeList = hashTable[index].nodes;
        for (Node<K, V> node : nodeList) {
            if (key.equals(node.key)) {
                nodeList.remove(node);
                size--;
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        int index = hash(key);
        if (index < hashTable.length && hashTable[index] != null) {
            List<Node<K, V>> list = hashTable[index].nodes;
            for (Node<K, V> node : list) {
                if (key.equals(node.key)) {
                    return node.value;
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public int size() {
        return size;
    }

    public void clear() {
        hashTable = null;
        size = 0;
    }

    @SuppressWarnings("/unchecked/")
    private void resize() {
        Node<K, V>[] temp = hashTable;
        hashTable = new Node[temp.length * 2];
        size = 0;

        for (Node<K, V> node : temp) {
            if (node != null) {
                for (Node<K, V> n : node.nodes) {
                    put(n.key, n.value);
                }
            }
        }
    }

    private int hash(K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }
}
