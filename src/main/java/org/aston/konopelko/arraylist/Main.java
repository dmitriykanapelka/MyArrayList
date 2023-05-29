package org.aston.konopelko.arraylist;


public class Main {
    public static void main(String[] args) {
        EntityArrayList<String> strings = new MyArrayList<>();
        strings.add("Dima");
        strings.add("Maksim");
        strings.add("Igor");
        strings.add("Artem");
        strings.add("Nasty");
        strings.delete(2);
        strings.clean();
        System.out.println(strings.get(2));
        System.out.println("========");
    }
}
