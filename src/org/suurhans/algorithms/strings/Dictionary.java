package org.suurhans.algorithms.strings;

public class Dictionary {

    public static String[] dictionary = new String[] { "car", "kitchen", "downtown" };

    public static void main(String[] args) {


        String sentence = "I was hauling my kitchen stuff from downtown with my CAR";
        System.out.println(sentence.split(" "));
    }

}
