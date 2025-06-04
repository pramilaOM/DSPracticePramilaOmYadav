import java.util.*;

public class TestNumFactoredBinaryTrees {

    public static final int MOD = 1000000007;

    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        Map<Integer, Long> map = new HashMap<>();
        map.put(arr[0], 1L);

        for (int i = 1; i < n; i++) {
            long count = 1;
            for (int j = 0; j < i; j++) {
                int v = arr[j];
                if (arr[i] % v == 0 && map.containsKey(arr[i] / v)) {
                    count += (map.get(v) * map.get(arr[i] / v)) % MOD;
                    count %= MOD;
                }
            }
            map.put(arr[i], count);

        }

        int result = 0;
        for (long val : map.values()) {
            result = (int) ((result + val) % MOD);
        }
        return result;

    }

    public static void main(String[] args) {
        TestNumFactoredBinaryTrees sol = new TestNumFactoredBinaryTrees();

        int[] arr1 = { 2, 4 };
        System.out.println("Test Case 1 Output: " + sol.numFactoredBinaryTrees(arr1)); // Expected: 3

        int[] arr2 = { 2, 4, 5, 10 };
        System.out.println("Test Case 2 Output: " + sol.numFactoredBinaryTrees(arr2)); // Expected: 7

        int[] arr3 = { 18, 3, 6, 2 };
        System.out.println("Test Case 3 Output: " + sol.numFactoredBinaryTrees(arr3)); // Add expected value after
                                                                                       // implementation

        int[] arr4 = { 2, 3, 5, 7, 11 };
        System.out.println("Test Case 4 Output: " + sol.numFactoredBinaryTrees(arr4)); // Only single-node trees

        int[] arr5 = { 2, 4, 8, 16 };
        System.out.println("Test Case 5 Output: " + sol.numFactoredBinaryTrees(arr5)); // Multiple possible trees from
                                                                                       // powers of 2
    }
}
