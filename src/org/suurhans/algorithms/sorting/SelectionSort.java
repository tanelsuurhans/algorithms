package org.suurhans.algorithms.sorting;

/**
 * Author: Tanel Suurhans
 * Created: 9/2/12 9:30 PM
 */
public class SelectionSort extends Sorting {

    private void run() {
        Integer minimum;
        Integer temp;

        for (int i = 0; i < this.values.length; i++) {

            minimum = i;

            for(int j = i + 1; j < values.length; j++) {
                if (values[minimum] > values[j]) {
                    minimum = j;
                }
            }

            if (minimum != i) {
                temp = values[minimum];

                values[minimum] = values[i];
                values[i] = temp;
            }

        }
    }

    public static void main(String[] args) {

        SelectionSort sort = new SelectionSort();

        sort.display();
        sort.run();
        sort.display();

    }

}
