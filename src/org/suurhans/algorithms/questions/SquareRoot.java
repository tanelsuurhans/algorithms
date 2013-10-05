package org.suurhans.algorithms.questions;

public class SquareRoot {

    public static Integer squareRoot(Integer number) {

        if (number == null) {
            throw new IllegalArgumentException("Cannot find square root of null");
        }

        if (number < 0) {
            throw new IllegalArgumentException("Cannot find square root of a negative number");
        }

        if (number == 0 || number == 1) {
            return number;
        }

        int half = Math.round(number / 2.0f);

        while (half >= 1) {
            int multiplied = Math.round(half * half);

            if (multiplied == number) {
                return half;
            } else if (multiplied > number) {
                half = Math.round(half / 2.0f);
            } else {
                half = half + Math.round(half / 2.0f);
            }
        }

        return -1;
    }

    public static Integer squareRoot2(Integer number) {

        if (number == null) {
            throw new IllegalArgumentException("Cannot find square root of null");
        }

        if (number < 0) {
            throw new IllegalArgumentException("Cannot find square root of a negative number");
        }

        if (number == 0 || number == 1) {
            return number;
        }

        int lower = 0;
        int upper = number / 2;

        while(upper - lower > 1) {

            int middle = (lower + upper) / 2;

            if (middle * middle <= number) {
                lower = middle;
            } else {
                upper = middle;
            }

        }

        return lower;
    }

    public static void main(String[] args) {

        System.out.println(squareRoot(81));
        System.out.println(squareRoot2(81));

    }

}
