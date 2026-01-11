package com.java_practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodsToLearn {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(22,11,3,4,51,67,89,9,10,1234,12,22,11,4);
        List<Integer> collect = list.stream()
                .filter(n -> n % 2 == 0)
                .map(x -> x / 2)
                .distinct()
                .sorted((a,b)->(b - a))
                .limit(4)
                .skip(1)
                .collect(Collectors.toList());

//        List<Integer> collect1 = Stream.iterate(0, n -> n + 1)
//                .limit(100)
//                .filter(n -> n % 2 == 0)
//                .skip(1)
//                .peek(n -> System.out.println(n))
//                .collect(Collectors.toList());
//
        Integer collect2 = Stream.iterate(0, n -> n + 1)
                .limit(101)
                .map(n -> n / 20)
                .distinct()
                .peek(System.out::println)
                .max((a,b)->(b-a))
                .get();
    }
}
