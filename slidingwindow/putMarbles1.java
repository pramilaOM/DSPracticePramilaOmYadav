import java.util.Arrays;

class putMarbles1 {
    public static long putMarbles(int[] weights, int k) {
        int len = weights.length;
        int[] arr = new int[len - 1];

        for (int i = 0; i < len - 1; i++) {
            arr[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(arr);
        long leftMost = 0;
        long RightMost = 0;
        for (int i = 0; i < k - 1; i++) {
            leftMost += arr[i];
            RightMost += arr[len - i - 2];

        }
        return RightMost - leftMost;

    }

    public static void main(String[] args) {
        int[] weights = { 1, 3, 5, 1 };
        int k = 2;
        System.out.println(putMarbles(weights, k));

    }

}