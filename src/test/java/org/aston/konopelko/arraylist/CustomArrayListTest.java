package org.aston.konopelko.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class CustomArrayListTest {

    @Test
    public void successfulCreationTest() {
        Assertions.assertDoesNotThrow(() -> new CustomArrayListImpl<>(String.class, 12));
    }

    @Test
    public void wrongCreationTest() {
        Assertions.assertThrows(RuntimeException.class, () -> new CustomArrayListImpl<>(String.class, -10));
    }

    @Test
    public void successfulAddition() {
        String newName = "Oleg";
        final CustomArrayList<String> names = buildNamesList();
        Assertions.assertTrue(names.add("Victoria"));
        names.add("Oleg");
        Assertions.assertEquals(newName, names.get(names.length() - 1));
    }

    @ParameterizedTest
    @MethodSource(value = "provideSuccessGetData")
    public void successfulGet(int idx, String value) {
        final CustomArrayList<String> names = buildNamesList();
        for (int i = 0; i < names.length(); i++) {
            Assertions.assertEquals(value, names.get(idx));
        }
    }

    @Test
    public void successfulGetLength() {
        final CustomArrayList<String> names = buildNamesList();
        Assertions.assertEquals(5, names.length());
    }

    @Test
    public void successfulSort() {
        final CustomArrayList<Integer> actual = buildNumbersList();
        final List<Integer> expected = List.of(1,2,3,4,5,6,7,8,9);
        actual.sort();
        for (int i = 0; i < actual.length(); i++) {
            Assertions.assertEquals(expected.get(i), actual.get(i));
        }

    }


    public static CustomArrayList<String> buildNamesList() {
        CustomArrayList<String> names = new CustomArrayListImpl<>(String.class);
        names.add("Dima");
        names.add("Maksim");
        names.add("Igor");
        names.add("Artem");
        names.add("Nasty");
        return names;
    }

    public static CustomArrayList<Integer> buildNumbersList() {
        CustomArrayList<Integer> numbers = new CustomArrayListImpl<>(Integer.class);
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);
        numbers.add(9);
        numbers.add(6);
        numbers.add(5);
        numbers.add(8);
        numbers.add(7);
        return numbers;
    }

    public static Stream<Arguments> provideSuccessGetData() {
        return Stream.of(
                Arguments.of(0, "Dima"),
                Arguments.of(1, "Maksim"),
                Arguments.of(2, "Igor"),
                Arguments.of(3, "Artem"),
                Arguments.of(4, "Nasty")
        );
    }
}
