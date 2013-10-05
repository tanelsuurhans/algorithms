package org.suurhans.algorithms.questions;

import java.util.*;

public class SumFinder {

    public class Pair {

        public int a;
        public int b;
        public int sum;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
            this.sum = a + b;
        }

        public String toString() {
            return "["  + a + ", " + b + "]";
        }
    }

    private int[] array;

    public SumFinder(int[] array) {
        this.array = array;
    }

    public List<Integer[]> findSlow(int target) {

        List<Integer[]> pairs = new ArrayList<Integer[]>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {

                if ((array[i] + array[j]) == target)
                    pairs.add(new Integer[] {array[i], array[j]});

            }
        }

        return pairs;
    }

    public List<Integer[]> findFast(int target) {

        List<Integer[]> pairs = new ArrayList<Integer[]>();
        Set<Integer> seen = new HashSet<Integer>();

        for (int i = 0; i < array.length; i++) {

            seen.add(array[i]);

            if (seen.contains(target - array[i]))
                pairs.add(new Integer[] { array[i], target - array[i] });

        }

        return pairs;
    }

    public List<Integer[]> find2Sum(int target) {

        List<Integer[]> list = new ArrayList<Integer[]>();

        Arrays.sort(array);

        int start = 0;
        int stop = array.length - 1;

        while(start < stop) {

            int a = array[start];
            int b = array[stop];

            int sum = a + b;

            if (sum > target) {
                stop--;
            } else if (sum < target) {
                start++;
            } else {
                list.add(new Integer[] {a, b});
                break;
            }

        }

        return list;
    }

    public List<Integer[]> findThree(int target) {

        List<Integer[]> triplets = new ArrayList<Integer[]>();
        Map<Integer, List<Pair>> sums = new HashMap<Integer, List<Pair>>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {

                if (i != j) {
                    int sum = array[i] + array[j];

                    if (!sums.containsKey(sum))
                        sums.put(array[i] + array[j], new ArrayList<Pair>());

                    sums.get(sum).add(new Pair(array[i], array[j]));
                }
            }
        }

        for (int i = 0; i < array.length; i++) {

            int diff = target - array[i];

            if (sums.containsKey(diff)) {

                for (Pair pair : sums.get(diff)) {
                    triplets.add(new Integer[] {pair.a, pair.b, array[i]});
                }

            }

        }

        return triplets;
    }

    public List<Integer[]> find3Sum(int target) {

        List<Integer[]> triplets = new ArrayList<Integer[]>();
        Arrays.sort(array);

        for (int i = 0; i < array.length - 3; i++) {

            int a = array[i];

            int start = i + 1;
            int stop = array.length - 1;

            while (start < stop) {

                int b = array[start];
                int c = array[stop];

                if (a + b + c > target) {
                    stop--;
                } else if (a + b + c < target) {
                    start++;
                } else {
                    triplets.add(new Integer[]{a, b, c});
                    break;
                }

            }

        }

        return triplets;
    }

    public void printList(List<Integer[]> list) {
        for (Integer[] pair : list) {
            System.out.println(Arrays.toString(pair));
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{ 1, 3, -5, 8, -2, 4, 2};
        SumFinder finder = new SumFinder(array);

        //finder.printList(finder.findSlow(11));
        //finder.printList(finder.findFast(11));
        //finder.printList(finder.find2Sum(11));

        finder.printList(finder.findThree(13));
        finder.printList(finder.find3Sum(13));
    }

}
