// Sliding Window Maximum
// https://leetcode.com/problems/subarray-sum-equals-k/description/

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow4 {
    public static void main(String[] args) {
        int ans = 0;
        String pat = "forr";
        String txt = "forxxorfxdofr";
        Map<Character, Integer> ptrcount = new HashMap<>();
        for (char c : pat.toCharArray()) {
            ptrcount.put(c, ptrcount.getOrDefault(c, 0) + 1);
        }

        // for(int i=0;i<pat.length();i++){
        // char ch = pat.charAt(i);
        // if(ptrcount.containsKey(ch)){
        // ptrcount.put(ch, ptrcount.get(ch)+1);
        // }
        // else{
        // ptrcount.put(ch, 1);
        // }
        // }
        ptrcount.forEach((k, v) -> System.out.println(k + " " + v));
        int size = ptrcount.size();
        int i = 0;
        for (int j = 0; j < txt.length(); j++) {
            char ch = txt.charAt(j);
            if (ptrcount.containsKey(ch)) {
                ptrcount.put(ch, ptrcount.get(ch) - 1);
                if (ptrcount.get(ch) == 0) {
                    size--;
                }
            }
            if (j - i + 1 == pat.length()) {
                if (size == 0) {
                    ans++;
                }
            }
        }
    }

}
