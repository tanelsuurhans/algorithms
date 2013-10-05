package org.suurhans.algorithms.questions;

import java.util.ArrayList;
import java.util.List;

// find all subsets of N that sum to T (unordered and contiguous)

public class PermutationSum {

    private int[] values;

    public PermutationSum(int[] values) {
        this.values = values;
    }

    public List<List<Integer>> find(int total) {
        return this.find(total, 0);
    }

    private List<List<Integer>> find(int total, int index) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (total == 0) {
            results.add(new ArrayList<Integer>());
        } else {

            for (int i = index; i < values.length; i++) {

                int current = values[i];
                int remainder = total - current;

                if (remainder >= 0) {

                    List<List<Integer>> combos = find(remainder, i + 1);

                    for (List<Integer> list : combos) {
                        list.add(current);
                        results.add(list);
                    }

                }
            }

        }

        return results;
    }

    public static void main(String[] args) {

        //int[] array = new int[] {5,9,1,3,4,2,6,7,11,10};
        int[] array = new int[] {1, 2, 3, 4, 5};

        PermutationSum finder = new PermutationSum(array);

        System.out.println(finder.find(5));

        /**
         * {5,9,1,3,4,2,6,7,11,10} => 10
         * 5 => recurse(10 - 5)
         * 9 => recurse(10 - 9)
         */

    }

}
