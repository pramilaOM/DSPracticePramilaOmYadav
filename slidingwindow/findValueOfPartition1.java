import java.util.Arrays;

class findValueOfPartition1 {
    public static int findValueOfPartition(int[] nums) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0;i< nums.length-1;i++){
           result =  Math.min(result,nums[i+1]-nums[i]);
           }
        
        return result;

    }

    public static void main(String[] args) {
        int[] nums = { 1,3,2,4};
        System.out.print(findValueOfPartition(nums));
    }

}