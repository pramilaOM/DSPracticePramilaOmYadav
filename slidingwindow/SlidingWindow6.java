
// Longest Substring With Without Repeating Characters | Variable Size Sliding Window
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/


import java.util.ArrayList;

public class SlidingWindow6 {
    public static void main(String[] args) {
        int[] arr = {12, 1, 3, 5 };
        int i = 0;
        int j = 0;
        int size = arr.length;
        ArrayList<Integer> al = new ArrayList<>();
        int k = 3;
        while (j < size) {
            if (arr[j] < 0) {
                al.add(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            }

            else if (j - i + 1 == k) {
                if (al.isEmpty()) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(al.get(0) + " ");
                    if (arr[i] == al.get(0))
                        al.remove(0);
                }
                i++;
                j++;
            }
        }
    }
}