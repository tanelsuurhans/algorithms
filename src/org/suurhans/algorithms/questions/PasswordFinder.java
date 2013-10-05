package org.suurhans.algorithms.questions;

import java.util.*;

public class PasswordFinder {

    private Map<Character, Character[]> mapping;
    private String password;

    public PasswordFinder(String password) {
        this.mapping = new HashMap<Character, Character[]>();
        this.mapping.put('a', new Character[] { 'A', '@', '4' });
        this.mapping.put('e', new Character[] { 'E', '3', '#' });
        this.mapping.put('l', new Character[] { 'I', '1', '!' });

        this.password = password;
    }

    public List<String> combinations() {
        return combinations(new ArrayList<String>(), "", 0);
    }

    public List<String> combinations(List<String> results, String prefix, Integer index) {

        if (index == password.length()) {

            results.add(prefix);

        } else {

            for (int i = index; i < password.length(); i++) {

                char current = password.charAt(i);

                if (Character.isAlphabetic(current) && mapping.containsKey(current)) {

                    for (Character c : mapping.get(current)) {
                        results = this.combinations(results, prefix.concat(Character.toString(c)), i + 1);
                    }

                }

                prefix = prefix.concat(Character.toString(current));

            }

            results.add(prefix);
        }

        return results;
    }

    public static void main(String[] args) {

        PasswordFinder finder = new PasswordFinder("kalamees");

        for (String combination : finder.combinations()) {
            System.out.println(combination);
        }

    }

}
