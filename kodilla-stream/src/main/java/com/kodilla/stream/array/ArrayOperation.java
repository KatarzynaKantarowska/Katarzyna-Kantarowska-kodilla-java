package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperation {

   static double getAverage(int[] numbers){
        IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .forEach(System.out::println);
        return IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .average()
                .getAsDouble();
        }
    }
