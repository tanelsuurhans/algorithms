package org.suurhans.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: Tanel Suurhans
 * Created: 9/4/12 10:38 PM
 */
public class Sorting {

    protected int[] values;

    public Sorting() {
        this.seed();
    }

    protected void display() {
        System.out.println(Arrays.toString(values));
    }

    protected void seed() {
        Random random = new Random();

        this.values = new int[20];

        for (int i = 0; i < values.length; i++) {
            this.values[i] = random.nextInt(100);
        }
    }

}
