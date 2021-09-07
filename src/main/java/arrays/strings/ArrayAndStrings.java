package arrays.strings;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayAndStrings {

    public static void main(String[] args) {

        List<String> input = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        HashMap<String, List<String>> sorted = new HashMap<String, List<String>>();

        for (String word : input) {
            char[] wordCharArray = word.toCharArray();
            Arrays.sort(wordCharArray);
            String sortedKey = new String(wordCharArray);

            sorted.putIfAbsent(sortedKey, new ArrayList<>());
            sorted.get(sortedKey).add(word);
        }

        List<List<String>> res = sorted.values().stream().collect(Collectors.toList());

        System.out.println(res);
    }
}
