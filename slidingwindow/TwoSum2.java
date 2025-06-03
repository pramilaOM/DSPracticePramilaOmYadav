import java.util.HashMap;

public class TwoSum2 {
    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start < end){
        if ((nums[start] + nums[end]) > target) {
            end--;
        } else if ((nums[start] + nums[end]) < target) {
            start++;
        } else if((nums[start] + nums[end]) == target){
            return new int[] { start+1, end+1 };
        }
    }
        throw new IllegalArgumentException("No two sum solution found");

    }

    public static void main(String[] args) {
        int[] nums = { -1,0 };
        int target = -1;
        int[] result = twoSum(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

}
