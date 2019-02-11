package com.liakhovskyi;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        elements = new Object[capacity];
    }

    @Override
    public T get(int index) {
        if (index >= elements.length && index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    @Override
    public void add(T t) {
        increaseSize();
        elements[size] = t;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            decreaseSize();
        }
    }

    @Override
    public int size() {
        return size;
    }

    private void increaseSize() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    private void decreaseSize() {
        if (elements.length > DEFAULT_CAPACITY && size == elements.length / 4) {
            elements = Arrays.copyOf(elements, elements.length / 2);
        }
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}
