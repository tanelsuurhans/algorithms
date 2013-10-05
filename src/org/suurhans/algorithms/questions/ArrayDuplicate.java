package org.suurhans.algorithms.questions;

public class ArrayDuplicate {

    private int[] values;

    public ArrayDuplicate(int[] array) {
        this.values = array;
    }

    public int[] remove() {

        int[] result = values;



        return result;
    }

    public static void main(String[] args) {

        int[] array = new int[] { 1, 2, 3, 3 ,5 ,6 ,2 };

        ArrayDuplicate remover = new ArrayDuplicate(array);
        remover.remove();
    }

}
