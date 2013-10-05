package org.suurhans.algorithms.questions;

public class LeastCommonMultiple {

    public static int lcm(int a, int b) {

        int small;
        int large;

        if (a > b) {
            small = b;
            large = a;
        } else {
            small = a;
            large = b;
        }

        int times = 1;
        int multiple = small;

        while (large % multiple != 0) {
            multiple = times * small;
            times++;
        }

        return multiple;
    }

    public static void main(String[] args) {

        System.out.println(lcm(30, 10));

    }

}
