import java.util.HashMap;
import java.util.Map;

class findErrorNums1 {
    public static int[] findErrorNums(int[] nums) {
        Map<Integer,Integer> data = new HashMap<>();
        for(int n :nums){
            data.put(n,data.getOrDefault(n, 0)+1);
        }
        int duplicate = -1, missing = -1;
        for(int i =1;i<=nums.length;i++){
            int count = data.getOrDefault(i, 0);
             if(count== 2){
                duplicate = i;
             } else if(count ==0){
                missing = i;
             }
        }
       
        return new int[]{duplicate,missing};

    }

    public static void main(String[] args) {
        int[] nums = { 1, 1 };
        int[] n = findErrorNums(nums);
        for (int num : n) {
            System.out.print(num+" ");
        }

    }
}