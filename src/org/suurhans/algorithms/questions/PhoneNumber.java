package org.suurhans.algorithms.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {

    private Map<Character, String> letters;
    private String number;

    public PhoneNumber(String number) {

        this.number = number;

        this.letters = new HashMap<Character, String>();
        this.letters.put('2', "ABC");
        this.letters.put('3', "DEF");
        this.letters.put('4', "GHI");
        this.letters.put('5', "JKL");
        this.letters.put('6', "MNO");
        this.letters.put('7', "PQRS");
        this.letters.put('8', "TUV");
        this.letters.put('9', "WXYZ");

    }

    public List<String> combinations() {
        return combinations(new ArrayList<String>(), "", 0);
    }

    public List<String> combinations(List<String> results, String prefix, Integer index) {

        // no more numbers left, store result
        if (index == number.length()) {

            results.add(prefix);

        } else {

            char current = number.charAt(index);

            // ignore non-digits and 0/1
            if (Character.isDigit(current) && letters.containsKey(current)) {

                // loop through all chars for the number
                for (Character c : letters.get(current).toCharArray()) {

                    // append the character to the passed prefix and recurse
                    results = this.combinations(results, prefix.concat(Character.toString(c)), index + 1);

                }

            } else {

                // in case of an ignore char, just increase index and recurse
                results = this.combinations(results, prefix, index + 1);

            }
        }

        return results;
    }

    public static void main(String[] args) {

        PhoneNumber number = new PhoneNumber("2323");
        List<String> combinations = number.combinations();

        for (String combination : combinations) {
            System.out.println(combination);
        }

        System.out.println("Total of " + combinations.size() + " combinations");

    }

}

