package com.wizerdshins.chapterone;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciNumbers {

    private static Map<Integer, BigInteger> cache = new HashMap<>();

    public long getFibonacciIteratively(int num) {

        long prev = 0;
        long next = 1;
        if (num < 2) return num;
        for (int i = 0; i < num; i++) {
            long tmp = next;
            next = prev + next;
            prev = tmp;
        }
        return prev;
    }

    public long getFibonacciWithArray(int num) {

        long[] nums = new long[num];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < num; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        return nums[nums.length - 1]; // or nums if we need get a series
    }

    public BigInteger getFibonacciRecursivelyAndCaching(int num) {

        BigInteger result;

        if (num < 2) return BigInteger.valueOf(num);
        if (cache.containsKey(num)) return cache.get(num);

        result = getFibonacciRecursivelyAndCaching(num - 2)
                .add(getFibonacciRecursivelyAndCaching(num - 1));
        cache.put(num, result);

        return result;
    }

    /**
     * best practice:
     * static int SQRT = Math.sqrt(5);
     * static int PHI = (SQRT + 1) / 2;
     * return (long)(Math.pow(PHI, num) / SQRT + 0.5);
     */
    public long getFibonacciWithClassicalFormula(int num) {
        return (long)((Math.pow(
                ((Math.sqrt(5) + 1) / 2), num)
                / (Math.sqrt(5)) + 0.5));
    }

    public static void main(String[] args) {}


}
