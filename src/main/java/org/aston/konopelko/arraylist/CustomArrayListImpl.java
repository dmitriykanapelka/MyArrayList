package org.aston.konopelko.arraylist;


import java.lang.reflect.Array;

public class CustomArrayListImpl<E extends Comparable<E>> implements CustomArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] values;
    private final Class<E> clazz;
    private int size;

    public CustomArrayListImpl(Class<E> clazz) {
        this.clazz = clazz;
        this.size = 0;
        values = (E[]) Array.newInstance(clazz, DEFAULT_CAPACITY);
    }

    public CustomArrayListImpl(Class<E> clazz, int capacity) {
        this.clazz = clazz;
        this.size = 0;
        if (capacity < 0) {
            throw new RuntimeException(String.format("Capacity %s incorrect", capacity));
        }
        values = (E[]) Array.newInstance(clazz, capacity);
    }

    @Override
    public boolean add(E e) {
        try {
            if (size < values.length) {
                values[size] = e;
                size++;
                return true;
            }
            E[] previous = values;
            values = (E[]) Array.newInstance(clazz, previous.length + previous.length / 2);
            System.arraycopy(previous, 0, values, 0, previous.length);
            values[size] = e;
            size++;
            return true;
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public E get(int index) {
        return (E) values[index];
    }

    @Override
    public void delete(int index) {
        try {
            Object[] first = values;
            values = (E[]) Array.newInstance(clazz, first.length - 1);
            System.arraycopy(first, 0, values, 0, index);
            int amountElementsAfterIndex = first.length - index - 1;
            System.arraycopy(first, index + 1, values, index, amountElementsAfterIndex);
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void clean() {
        values = (E[]) Array.newInstance(clazz, values.length);
    }

    @Override
    public void sort() {
        int from = 0;
        int to = size - 1;
        quickSort(values, from, to);
    }

    @Override
    public int length() {
        return size;
    }

    private void quickSort(E[] array, int from, int to) {
        if (from < to) {
            int divideIndex = partition(array, from, to);
            quickSort(array, from, divideIndex - 1);
            quickSort(array, divideIndex, to);
        }
    }

    private int partition(E[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        E pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (arr[leftIndex].compareTo(pivot) < 0) {
                leftIndex++;
            }

            while (arr[rightIndex].compareTo(pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private void swap(E[] array, int index1, int index2) {
        E tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
