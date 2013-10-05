package org.suurhans.algorithms.questions;

public class Kadane {

    public static int calculate(int[] array, int position, int jump) {
        int maximum = Integer.MIN_VALUE;
        int current = 0;

        int i = position;

        while(i < array.length) {

            current += array[i];

            if (current > maximum) {
                maximum = current;
            }

            if (current < 0) {
                current = 0;
            }

            i += jump;
        }

        return maximum;
    }

    public static void main(String[] args) {

        int[] array = {-4, -1, -2, -9};
        //int a = calculate(array, 0, 2);
        //int b = calculate(array, 1, 2);

        //System.out.println(a);
        //System.out.println(b);

        //System.out.println(calculate(array, 0, 1));

        System.out.println(calculate(array, 0, 1));

    }

}
