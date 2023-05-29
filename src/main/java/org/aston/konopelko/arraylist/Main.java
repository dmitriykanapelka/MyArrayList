package org.aston.konopelko.arraylist;


public class Main {
    public static void main(String[] args) {
//        CustomArrayList<String> strings = new CustomArrayListImpl<>(String.class);
//        strings.add("Dima");
//        strings.add("Maksim");
//        strings.add("Igor");
//        strings.add("Artem");
//        strings.add("Nasty");
//        System.out.println(strings.get(3));
//        strings.delete(2);
//        System.out.println(strings.get(2));
//        strings.clean();
//        System.out.println(strings.get(2));
//        System.out.println("========");


        CustomArrayList<Integer> nums = new CustomArrayListImpl<>(Integer.class);
        nums.add(3);
        nums.add(1);
        nums.add(4);
        nums.add(2);
        nums.add(9);
        nums.add(6);
        nums.add(5);
        nums.add(8);
        nums.add(7);
        for (int i = 0; i < nums.length(); i++) {
            System.out.println(nums.get(i));
        }
        System.out.println("----------");
        nums.sort();
        for (int i = 0; i < nums.length(); i++) {
            System.out.println(nums.get(i));
        }
    }
}
