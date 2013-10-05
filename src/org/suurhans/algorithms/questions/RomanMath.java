package org.suurhans.algorithms.questions;

import java.util.*;

public class RomanMath {

    public static Map<Character, Integer> mapping;

    public RomanMath() {
        mapping = new LinkedHashMap<Character, Integer>();
        mapping.put('M', 1000);
        mapping.put('D', 500);
        mapping.put('C', 100);
        mapping.put('L', 50);
        mapping.put('X', 10);
        mapping.put('V', 5);
        mapping.put('I', 1);
    }

    public String add(String string1, String string2) {

        Integer number1 = this.decode(string1);
        Integer number2 = this.decode(string2);
        Integer result  = number1 + number2;

        return encode(result);
    }

    private Integer decode(String source) {

        Integer result = 0;

        for (int i = 0; i < source.length() - 1; i++) {

            int curr = mapping.get(source.charAt(i));
            int next = mapping.get(source.charAt(i + 1));

            if (curr < next) {
                result -= curr;
            } else {
                result += curr;
            }

        }

        result += mapping.get(source.charAt(source.length() - 1));

        return result;
    }

    private String encode(Integer number) {

        StringBuilder builder = new StringBuilder();

        for (Map.Entry<Character, Integer> set : mapping.entrySet()) {
            while (number >= set.getValue()) {
                builder.append(set.getKey());
                number -= set.getValue();
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        RomanMath calculator = new RomanMath();

        System.out.println(calculator.add("CCCLXIX", "CDXLVIII"));
    }

}
