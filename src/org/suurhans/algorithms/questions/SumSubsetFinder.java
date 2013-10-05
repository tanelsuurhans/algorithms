package org.suurhans.algorithms.questions;

// find all subsets of N that sum to T (ordered)

import java.util.ArrayList;
import java.util.List;

public class SumSubsetFinder {

    private int[] values;

    public SumSubsetFinder(int[] values) {
        this.values = values;
    }

    public List<List<Integer>> find(int total) {
        return this.find(total, new ArrayList<Integer>());
    }

    private List<List<Integer>> find(int total, List<Integer> partial) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (total == 0) {
            results.add(partial);
        } else {

            for (int i = 0; i < values.length; i++) {

                int current = values[i];

                if (partial.contains(current) || current > total)
                    continue;

                List<Integer> chain = new ArrayList<Integer>();

                chain.addAll(partial);
                chain.add(current);

                results.addAll(find(total - current, chain));

            }
        }

        return results;
    }

    public static void main(String[] args) {

        //int[] array = new int[] {5,9,1,3,4,2,6,7,11,10};
        int[] array = new int[] {1, 2, 3, 4, 5};

        SumSubsetFinder finder = new SumSubsetFinder(array);
        System.out.println(finder.find(5));


    }

}
