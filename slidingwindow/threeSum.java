import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static List<List<Integer>> threeSum2S(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> output = threeSum2S(nums);
        System.out.println(output);

    }

}
