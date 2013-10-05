package org.suurhans.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: Tanel Suurhans
 * Created: 9/2/12 8:34 PM
 *
 * Worst case pow(n, 2)
 * compares i and i - 1 and swaps if i is smaller
 */
public class BubbleSort extends Sorting {

    private void run() {
        Integer temp;
        boolean running = true;

        while(running) {
            running = false;

            for(int i = 1; i < this.values.length; i++) {
                if (this.values[i] < this.values[i - 1]) {
                    temp = this.values[i - 1];

                    this.values[i - 1] = this.values[i];
                    this.values[i] = temp;

                    running = true;
                }
            }
        }

    }

    public static void main(String[] args) {

        BubbleSort sort = new BubbleSort();

        sort.display();
        sort.run();
        sort.display();

    }

}
