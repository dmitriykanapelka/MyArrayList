package org.aston.konopelko.arraylist;


import java.util.Iterator;

public class MyArrayList<E> implements EntityArrayList<E> {
    private E[] values;

    public MyArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(Object e) {
        try {
            E[] first = values;
            values = (E[]) new Object[first.length + 1];
            System.arraycopy(first, 0, values, 0, first.length);
            values[values.length - 1] = (E) e;
            return true;
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public void delete(int index) {
        try {
            E[] first = values;
            values = (E[]) new Object[first.length - 1];
            System.arraycopy(first, 0, values, 0, index);
            int amountElementsAfterIndex = first.length - index - 1;
            System.arraycopy(first, index + 1, values, index, amountElementsAfterIndex);
        } catch (ClassCastException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void clean() {
        values = (E[]) new Object[values.length];
    }

    @Override
    public void sort() {
        int minValue = (int) values[0];
        int minIndex = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] < minValue) {
                minValue = (int) values[i];
                minIndex = i;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new MyArrayIterator<E>(values);
    }
}
