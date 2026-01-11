package com.java_practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class waysToCreateStream {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        Stream<String> mtd1 = list.stream();

        int[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> mtd2 = Arrays.stream(arr).boxed();

        Stream<Integer> mt3 = Stream.of(1, 2, 3, 4, 5);

        List<Integer> mtd4 = Stream.iterate(0, n -> n + 1).limit(100).collect(Collectors.toList());

        Stream<Integer> mtd5 = Stream.generate(() -> (int) (Math.random() * 1000)).limit(100);

        System.out.println(mtd1);
        System.out.println(mtd2);
        System.out.println(mt3);
        System.out.println(mtd4);
        System.out.println(mtd5);

    }

}
