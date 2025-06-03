import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class findOriginalArray {
    public static int[] findOriginalArray1(int[] arr) {
        if (arr.length % 2 != 0) {
            return new int[0];
        }
        Arrays.sort(arr);
        Map<Integer, Integer> data = new HashMap<>();
        for (int n : arr) {
            data.put(n, data.getOrDefault(n, 0) + 1);
        }

        int[] res = new int[arr.length / 2];
        int idx = 0;
        for (int n : arr) {
            if (data.get(n) == 0)
                continue;
            if (n == 0) {
                if (data.get(n) < 2)
                    return new int[0];
                data.put(n, data.get(n) - 2);
                res[idx++] = 0;
            } else {
                if (data.getOrDefault(n*2,0) ==0)
                    return new int[0];
                data.put(n, data.get(n) - 1);
                data.put(n * 2, data.get(n * 2) - 1);
                res[idx++] = n;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] matrix = { 1, 3, 4, 2, 6, 8 };
        int[] ans = findOriginalArray1(matrix);
        for (int n : ans) {
            System.out.print(n + " ");
        }

    }
}