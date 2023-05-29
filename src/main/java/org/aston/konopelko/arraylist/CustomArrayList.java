package org.aston.konopelko.arraylist;

public interface CustomArrayList<E> {

    boolean add(E e);

    E get(int index);

    void delete(int index);

    void clean();

    void sort();

    int length();
}
