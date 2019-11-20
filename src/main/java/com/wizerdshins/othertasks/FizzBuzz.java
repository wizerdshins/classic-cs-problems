package com.wizerdshins.othertasks;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = "FizzBuzz";

    public int[] initialize() {
        return IntStream.iterate(1, i -> i + 1)
                .limit(100)
                .toArray();
    }

    public void getFizzBuzz(int[] array) {

        for (int i = 0; i < array.length; i++) {

            boolean isDividedByThree = array[i] % 3 == 0;
            boolean isDividedByFive = array[i] % 5 == 0;

            if (isDividedByThree && isDividedByFive) {
                System.out.println("Number: " + array[i] + ": " + FIZZ_BUZZ);
            } else if (isDividedByThree) {
                System.out.println("Number: " + array[i] + ": " + FIZZ);
            } else if (isDividedByFive) {
                System.out.println("Number: " + array[i] + ": " + BUZZ);
            } else {
                System.out.println("Number: " + array[i] + ": none");
            }
        }
    }

    public void getFizzBuzzWithStream(int[] array) {
        Arrays.stream(array)
                .mapToObj(i -> i % 3 == 0
                        ? (i % 5 == 0 ? "Number: " + i + ": " + FIZZ_BUZZ
                        : "Number: " + i + ": " + FIZZ)
                        : (i % 5 == 0 ? "Number: " + i + ": " + BUZZ
                        : "Number: " + i + ": " + "none"))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {}
}
