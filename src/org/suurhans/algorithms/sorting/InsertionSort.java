package org.suurhans.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: Tanel Suurhans
 * Created: 9/2/12 7:23 PM
 *
 * Worst case pow(n, 2)
 */
public class InsertionSort extends Sorting {

    private void run() {
        for(int i = 1; i < this.values.length; i++) {

            int v = values[i];
            int j = i;

            while (j > 0 && values[j - 1] > v) {
                values[j] = values[j - 1];
                j--;
            }

            values[j] = v;
        }
    }

    public static void main(String[] args) {

        InsertionSort sort = new InsertionSort();

        sort.display();
        sort.run();
        sort.display();

    }

}