package org.suurhans.algorithms.strings;

import java.util.Arrays;
import java.util.Iterator;

public class PalindromeFinder {

    public boolean isPalindrome(String source) {

        if (source == null) {
            return false;
        }

        source = source.toLowerCase().replaceAll("\\W", "");

        int last = source.length() - 1;
        int half = source.length() / 2;

        for(int i = 0; i <= half; i++) {
            char a = source.charAt(i);
            char b = source.charAt(last - i);

            if (a != b) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindromeNocopy(String source) {

        Iterator<Character> forward = new ForwardIterator(source);
        Iterator<Character> backward = new BackwardIterator(source);

        while (forward.hasNext() && backward.hasNext()) {
            char a = forward.next();
            char b = backward.next();

            if (a != b)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeFinder finder = new PalindromeFinder();

        String sentence = "tenet c is a basis, a basic,,,,, tenet.";

        System.out.println(finder.isPalindromeNocopy(sentence));
    }

    public class ForwardIterator implements Iterator<Character> {

        private String string;
        private Integer index;

        public ForwardIterator(String string) {
            this.index = -1;
            this.string = string;
        }

        public boolean hasNext() {
            return this.nextIndex() > 0;
        }

        public Character next() {
            this.index = this.nextIndex();
            return this.string.charAt(this.index);
        }

        public void remove() {

        }

        private Integer nextIndex() {
            for (int i = this.index + 1; i < this.string.length() - 1; i++) {
                if (Character.isAlphabetic(string.charAt(i)))
                    return i;
            }

            return -1;
        }

    }

    public class BackwardIterator implements Iterator<Character> {

        private String string;
        private Integer index;

        public BackwardIterator(String string) {
            this.index = string.length();
            this.string = string;
        }

        public boolean hasNext() {
            return this.nextIndex() > 0;
        }

        public Character next() {
            this.index = this.nextIndex();
            return this.string.charAt(this.index);
        }

        public void remove() {

        }

        private Integer nextIndex() {
            for (int i = this.index - 1; i >= 0; i--) {
                if (Character.isAlphabetic(this.string.charAt(i)))
                    return i;
            }

            return -1;
        }
    }

}

