package org.suurhans.algorithms.questions;

import java.util.ArrayList;
import java.util.List;

// ordered combinations of 1..n
public class Combinations {

    public List<List<Integer>> find(int total) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (total == 0) {

            results.add(new ArrayList<Integer>());

        } else {

            for (int i = 1; i <= total; i++) {

                List<List<Integer>> subResult = find(total - i);

                for (List<Integer> list : subResult) {
                    list.add(i);

                    results.add(list);
                }

            }

        }

        return results;
    }

    public static void main(String[] args) {

        Combinations finder = new Combinations();

        System.out.println(finder.find(4));

    }

}
