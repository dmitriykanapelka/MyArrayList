package org.aston.konopelko.arraylist;

/**
 * Интерфейс CustomArrayList с описанием методов которые реализованы в классе CustomArrayListImpl.
 */
public interface CustomArrayList<E> {

    boolean add(E e);

    E get(int index);

    void delete(int index);

    void clean();

    void sort();

    int length();
}
