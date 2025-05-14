//Maximum Sum Subarray of size K | Sliding Window
//https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
public class SlidingWindow1{
    public static void main(String[] args) {
        
        int[] arr = {2,5,1,8,2,9,1};
        int i =0; int j =0; int sum = 0; int max = Integer.MIN_VALUE;
        int size = arr.length;
        int k = 3;
        while(j < size){
            sum = sum + arr[j];
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 ==k){
                max = Math.max(max, sum);
                sum = sum - arr[i];
                j++;
                i++;
            }

        }
    System.out.println(max);
    }
}
