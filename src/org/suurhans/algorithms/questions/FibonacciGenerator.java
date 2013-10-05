package org.suurhans.algorithms.questions;

import java.util.Arrays;

public class FibonacciGenerator {

    public static int[] generate(int length) {

        if (length < 2) {
            throw new IllegalArgumentException("Cannot generate a list shorter than 2 elements");
        }

        int[] sequence = new int[length];
        int i = 0;

        int a = -1;
        int b = 1;
        int c = 0;

        while (i < length) {
            c = a + b;
            a = b;
            b = c;

            sequence[i] = c;

            i++;
        }

        return sequence;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(generate(2)));
        System.out.println(Arrays.toString(generate(10)));

    }

}
