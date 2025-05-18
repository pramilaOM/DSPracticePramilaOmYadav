//Count Occurences of Anagrams
//https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

import java.util.HashMap;
import java.util.Map;

public class rough {
    public static void main(String[] args) {

        String s = "for";
        Map<Character, Integer> countmap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countmap.put(c, countmap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : countmap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        

    }

}
