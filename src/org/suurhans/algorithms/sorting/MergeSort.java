package org.suurhans.algorithms.sorting;

/**
 * Author: Tanel Suurhans
 * Created: 9/2/12 11:26 PM
 */
public class MergeSort extends Sorting {

    public void run() {
        this.values = sort(values);
    }

    private int[] sort(int[] values) {

        if (values.length <= 1)
            return values;

        int middle = values.length / 2;

        int[] left = new int[middle];
        int[] right = new int[values.length - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = values[i];
        }

        for (int i = 0; i < values.length - middle; i++) {
            right[i] = values[i + middle];
        }

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int indexA = 0;
        int indexL = 0;
        int indexR = 0;

        while (indexL < left.length && indexR < right.length) {

            int elemL = left[indexL];
            int elemR = right[indexR];

            if (elemL >= elemR) {
                result[indexA] = elemR;
                indexR++;
            } else {
                result[indexA] = elemL;
                indexL++;
            }

            indexA++;
        }

        while (indexL < left.length) {
            result[indexA] = left[indexL];
            indexL++;
            indexA++;
        }

        while (indexR < right.length) {
            result[indexA] = right[indexR];
            indexR++;
            indexA++;
        }

        return result;
    }

    public static void main(String[] args) {

        MergeSort sorter = new MergeSort();

        sorter.display();
        sorter.run();
        sorter.display();

    }

}
