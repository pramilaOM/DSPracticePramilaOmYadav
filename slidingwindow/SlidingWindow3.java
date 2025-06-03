//Count Occurences of Anagrams
//https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlidingWindow3 {

    public static int findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int k = p.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            char ch = p.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int count = map.size();
        int i = 0, j = 0;

        while (j < s.length()) {
            // Calculation:
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (count == 0) {
                    ans.add(i);
                }
                char ch1 = s.charAt(i);
                if (map.containsKey(ch1)) {
                    map.put(ch1, map.get(ch1) + 1);
                    if (map.get(ch1) == 1) {
                        count++;
                    }
                }
                i++;
                j++;
            }
        }

        return ans.size();
    }

    public static void main(String[] args) {
        String txt = "aabaabaa";
        String pat = "aaba";
        System.out.println(findAnagrams(txt, pat));
        // findAnagrams(txt, pat);
    }
}