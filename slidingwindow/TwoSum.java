import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (count.containsKey(rem)) {
                return new int[] { count.get(rem), i };
            }
            count.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution found");

    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

}
