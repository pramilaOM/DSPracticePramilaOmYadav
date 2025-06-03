import java.util.Arrays;

class minPairSum1 {
    public static int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < n / 2; i++) {
            result = Math.max(result, nums[i] + nums[n - 1 - i]);

        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 4, 2, 4, 6 };
        System.out.println(minPairSum(nums));
    }
}