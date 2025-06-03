import java.util.Arrays;

class largestPerimeter1 {
    public static int largestPerimeter(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] < nums[i + 1] + nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 2 };
        int n = largestPerimeter(nums);
        System.out.println(n);

    }

}