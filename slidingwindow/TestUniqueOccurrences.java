import java.util.*;

public class TestUniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {

        int[] data = new int[2001];

        for (int x : arr) {
            data[x + 1000]++;
        }
        Arrays.sort(data);

        for (int i = 1; i < 2001; i++) {
            if (data[i] == 0 ) continue;

            int idx = Math.abs(data[i]);

            if(data[idx] < 0){
                return false;
            }

            data[idx] = -1;
        }

        return true;

    }

    public static void main(String[] args) {
        TestUniqueOccurrences sol = new TestUniqueOccurrences();

        int[] arr1 = { 1, 2, 2, 1, 1, 3 };
        System.out.println("Test Case 1 Output: " + sol.uniqueOccurrences(arr1)); // Expected: true

        int[] arr2 = { 1, 2 };
        System.out.println("Test Case 2 Output: " + sol.uniqueOccurrences(arr2)); // Expected: false

        int[] arr3 = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        System.out.println("Test Case 3 Output: " + sol.uniqueOccurrences(arr3)); // Expected: true
    }
}
