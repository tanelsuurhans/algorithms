package org.suurhans.algorithms.questions;

public class Division {

    public static double divide(double a, double b) {

        double multiplier = 1;
        double result = 0;

        while (result >= 0) {

            result = a - (multiplier * b);

            if (result > 0) {
                multiplier++;
            } else {
                return multiplier;
            }

        }

        return result;
    }

    public static double divideByAddition(double a, double b) {

        double result = 1;
        double sum = b;

        while (sum < a) {
            sum = b * result;
            result++;
        }

        return result - 1;
    }

    public static void main(String[] args) {

        System.out.println(divide(6, 2));
        System.out.println(divideByAddition(81, 9));

    }

}
