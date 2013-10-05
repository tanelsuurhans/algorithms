package org.suurhans.algorithms.strings;

import java.util.*;

public class AnagramFinder {

    public static String sorted(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        Arrays.sort(chars);

        return Arrays.toString(chars);
    }

    public static void main(String[] args) {

        List<String> words = new ArrayList<String>();
        Map<String, List<String>> anagrams = new HashMap<String, List<String>>();

        words.add("Orchestra");
        words.add("Carthorse");
        words.add("Random");
        words.add("Diuretics");
        words.add("Crudities");

        for (String word : words) {

            String sorted = sorted(word);

            if (!anagrams.containsKey(sorted))
                anagrams.put(sorted, new ArrayList<String>());

            anagrams.get(sorted).add(word);
        }

        Iterator<Map.Entry<String, List<String>>> iterator = anagrams.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();

            if (entry.getValue().size() > 1)
                System.out.println(entry.getValue());
        }
    }

}
