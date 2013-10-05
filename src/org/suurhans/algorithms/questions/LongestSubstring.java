package org.suurhans.algorithms.questions;

public class LongestSubstring {

    public static String common(String a, String b) {

        StringBuilder builder = new StringBuilder();

        a = a.toLowerCase();
        b = b.toLowerCase();

        int[][] matches = new int[a.length()][b.length()];

        int max = 0;
        int start = 0;

        for (int i = 0; i < a.length(); i++) {
            for(int j = 0; j < b.length(); j++) {

                if (a.charAt(i) == b.charAt(j)) {

                    if (i == 0 || j == 0) {
                        matches[i][j] = 1;
                    } else {
                        matches[i][j] = 1 + matches[i - 1][j - 1];
                    }

                    if (matches[i][j] > max) {

                        max = matches[i][j];

                        int chunk = i - max + 1;

                        if (start == chunk) {
                            builder.append(a.charAt(i));
                        } else {
                            start = chunk;

                            builder = new StringBuilder();
                            builder.append(a.substring(start, i + 1));
                        }

                    }
                }
            }
        }

        return builder.toString();
    }

    public static String longestPalindrome(String source) {

        String a = source;
        String b = (new StringBuilder(source)).reverse().toString();

        return common(a, b);
    }

    public static void main(String[] args) {

        String a = "tenet c is a basis, a basic,,,,, tenet.";
        String b = ".tenet ,,,,,cisab a ,sisab a si c tenet";

        System.out.println(common(a, b));
        //System.out.println(longestPalindrome("abcdcbbcdeedcba"));


    }

}
