package org.suurhans.algorithms.questions;

import java.util.ArrayList;
import java.util.List;

// find all subsets of size k (supports ordered, unordered, contiguous)

public class SubsetFinder {

    private int[] values;
    private List<List<Integer>> subsets;

    public SubsetFinder(int[] values) {
        this.values = values;
    }

    public List<List<Integer>> find(int size) {
        subsets = new ArrayList<List<Integer>>();

        process(size, 0, new ArrayList<Integer>());

        return subsets;
    }

    private void process(int size, int index, List<Integer> set) {

        if (set.size() == size) {

            subsets.add(set);

        } else if (set.size() < size) {

            for (int i = 0; i < values.length; i++) {

                //if (set.contains(values[i]))
                    //continue;

                List<Integer> subset = new ArrayList<Integer>();

                subset.addAll(set);
                subset.add(values[i]);

                process(size, index + 1, subset);
            }

        }

    }

    public static void main(String[] args) {

        int[] values = new int[] {1, 2, 3};

        SubsetFinder finder = new SubsetFinder(values);

        System.out.println(finder.find(2));
        //System.out.println(finder.find(3));


    }

}
