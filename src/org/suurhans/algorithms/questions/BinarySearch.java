package org.suurhans.algorithms.questions;

public class BinarySearch {

    private Integer[] values;

    public BinarySearch(Integer[] values) {
        this.values = values;
    }

    public Integer find(Integer value) {
        int start = 0;
        int stop = this.values.length - 1;

        while(start <= stop) {

            Integer middle = (start + stop) / 2;

            if (values[middle].equals(value))
                return middle;

            // breakpoint is on the right - regular sorted array
            if (values[start] < values[middle]) {

                if (value >= values[start] && value < values[middle]) {
                    stop = middle - 1;
                } else {
                    start = middle + 1;
                }


            // breakpoint is on the left - rotated array
            } else if (values[start] > values[middle]) {

                if (value > values[middle] && value <= values[stop]) {
                    start = middle + 1;
                } else {
                    stop = middle - 1;
                }

            } else {
                if (values[start].equals(value))
                    return start;

                start++;
            }

        }

        return -1;
    }

    public Integer findOffset() {
        int start = 0;
        int stop = values.length - 1;

        while(start <= stop) {

            int middle = (start + stop) / 2;
            int value  = values[middle];

            if (middle < values.length && value > values[middle + 1]) {
                return middle + 1;
            } else if (middle > 0 && value < values[middle - 1]) {
                return middle;
            } else {
                if (value < values[start]) {
                    stop = middle - 1;
                } else if (value > values[stop]) {
                    start = middle + 1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        BinarySearch search = new BinarySearch(new Integer[]{ 14, 15, 16, 1, 2, 3, 5, 6, 9, 10 });

        System.out.println(search.find(1));
        System.out.println(search.find(15));

        System.out.println(search.findOffset());
    }

}
