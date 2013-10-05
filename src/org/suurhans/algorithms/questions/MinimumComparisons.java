package org.suurhans.algorithms.questions;

import java.util.ArrayList;
import java.util.List;

public class MinimumComparisons {

    public static void main(String[] args) {

        int[] values = new int[] { 11, 6, 3, 8, 9, 4, 7, 5, 1 };

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < values.length; i += 2) {

            int a = values[i];

            if (i == values.length - 1) {

                if (a > max)
                    max = a;

                if (a < min)
                    min = a;

            } else {

                int b = values[i + 1];

                int small;
                int large;

                // 1st comparison
                if (a > b) {
                    small = b;
                    large = a;
                } else {
                    small = a;
                    large = b;
                }

                // second comparison
                if (small < min)
                    min = small;

                // third comparison
                if (large > max)
                    max = large;

            }
        }

        System.out.println("MIN: " + min);
        System.out.println("MAX: " + max);

    }

}
