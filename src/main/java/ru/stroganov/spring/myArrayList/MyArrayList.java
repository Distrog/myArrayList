package ru.stroganov.spring.myArrayList;

import ru.stroganov.spring.myArrayList.exception.ArrayDoesNotContainsElementException;
import ru.stroganov.spring.myArrayList.exception.ArrayIsNullException;
import ru.stroganov.spring.myArrayList.exception.ArrayOverFlowException;
import ru.stroganov.spring.myArrayList.exception.IndexIsGreaterThanArraySizeException;

public class MyArrayList implements StringList {
    private String[] array;
    private int size = 0;
    private final int capacity;

    public MyArrayList() {
        capacity = 100;
        array = new String[capacity];
    }

    @Override
    public String add(String item) {
        if (size < capacity) {
            array[size] = item;
            size++;
            return item;
        } else {
            throw new ArrayOverFlowException();
        }
    }

    @Override
    public String add(int index, String item) {

        if (index < size && index + 1 < capacity) {
            size++;
            for (int i = size - 1; i >= index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = item;
            return item;
        } else {
            throw new IndexIsGreaterThanArraySizeException();
        }
    }

    @Override
    public String set(int index, String item) {
        if (index < size) {
            array[index] = item;
            return item;
        } else {
            throw new IndexIsGreaterThanArraySizeException();
        }
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                for (int j = i; j <= size - 1; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                return item;
            }
        }
        throw new ArrayDoesNotContainsElementException();
    }

    @Override
    public String remove(int index) {
        if (index < size) {
            String removed = array[index];
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            return removed;
        }
        throw new IndexIsGreaterThanArraySizeException();
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size-1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < size) {
            return array[index];
        }
        throw new IndexIsGreaterThanArraySizeException();
    }

    @Override
    public boolean equals(StringList other) {
        if (other == null) {
            throw new ArrayIsNullException();
        }
        if (size != other.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        array = new String[capacity];
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }
}
