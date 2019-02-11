package com.liakhovskyi;

public class LinkedList<T> implements List<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    @Override
    public T get(int index) {
        checkForIndexException(index);
        Node<T> elem = first;
        for (int i = 0; i < index; i++) {
            elem = elem.next;
        }
        return elem.item;
    }

    @Override
    public void add(T t) {
        Node<T> node;
        if (size == 0) {
            node = new Node<>(null, t, null);
            first = node;
            last = node;
        } else {
            node = new Node<>(last, t, null);
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        checkForIndexException(index);
        isEmpty();

        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        Node<T> prev = node.prev;
        Node<T> next = node.next;

        if (node.prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (node.next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedList{elements=[");
        for (int i = 0; i < size(); i++) {
            stringBuilder.append(get(i) + ", ");
        }
        stringBuilder.append("\b\b], size=" + size() + "}");
        return stringBuilder.toString();
    }

    private void checkForIndexException(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void isEmpty() {
        if (size == 0) {
            throw new NullPointerException("Empty list");
        }
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

