package org.suurhans.algorithms.questions;

public class BinaryMath {

    public static String add(String string1, String string2) {

        int max = Math.max(string1.length(), string2.length());

        string1 = zeroPad(string1, max);
        string2 = zeroPad(string2, max);

        StringBuilder result = new StringBuilder();
        boolean carry = false;

        for (int i = max - 1; i >= 0; i--) {

            char char1 = string1.charAt(i);
            char char2 = string2.charAt(i);
            char output;

            if ((char1 == '1' && char2 == '0') || (char1 == '0' && char2 == '1')) {

                output = carry ? '0' : '1';

            } else if (char1 == '1' && char2 == '1') {

                output = carry ? '1' : '0';
                carry = true;

            } else {

                output = carry ? '1' : '0';
                if (carry) carry = false;

            }

            result.append(Character.valueOf(output));
        }

        if (carry) result.append("1");

        return result.reverse().toString();
    }

    public static String zeroPad(String source, int length) {

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < length - source.length(); i++) {
            buffer.append("0");
        }

        buffer.append(source);

        return buffer.toString();
    }

    public static void main(String[] args) {

        // 25000 - 7500
        System.out.println(add("110000110101000", "1110101001100"));

    }

}
