package org.suurhans.algorithms.questions;

import com.sun.jdi.IntegerType;

import java.util.Arrays;

public class ArrayRotate {

    public static Integer[] rotate(Integer[] array) {
        int temp = array[0];

        for (int i = 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }

        array[array.length - 1] = temp;

        return array;
    }

    public static Integer[] rotate(Integer[] array, int count) {

        if (array == null)
            throw new IllegalArgumentException("Cannot rotate a null array");

        if (count == 0 || count == array.length || array.length == 0)
            return array;

        if (count > array.length)
            count = count - array.length;

        for (int i = 0; i < count; i++) {
            array = rotate(array);
        }

        return array;
    }

    public static Integer[] rotateTemp(Integer[] array, int count) {

        if (array == null)
            throw new IllegalArgumentException("Cannot rotate a null array");

        if (count == 0 || count == array.length || array.length == 0)
            return array;

        if (count > array.length)
            count = count - array.length;

        Integer[] temp = new Integer[array.length];

        for (int i = 0; i < array.length; i++) {

            if (i >= count) {
                temp[i - count] = array[i];
            } else {
                temp[array.length - count + i] = array[i];
            }

        }

        return temp;
    }

    public static Integer[] swap(Integer[] array, int start, int end) {

        if (array.length < (end - start))
            return array;

        while (start < end) {
            int a = array[start];
            int b = array[end];

            array[start] = b;
            array[end]   = a;

            start++;
            end--;
        }

        return array;
    }

    public static Integer[] rotateInplace(Integer[] array, int count) {

        array = swap(array, 0, count - 1);
        array = swap(array, count, array.length - 1);
        array = swap(array, 0, array.length - 1);

        return array;
    }

    public static void main(String[] args) {

        Integer[] array = new Integer[]{ 1, 2, 3, 4, 5, 6, 7 };
        Integer[] rotated = rotateInplace(array, 4);

    }

}
