class sumEvenAfterQueries {
    public static int[] sumEvenAfterQueries1(int[] nums, int[][] queries) {
        int sum = 0;
        for (int n : nums) {
            if (n % 2 == 0) {
                sum = sum + n;
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int indx = queries[i][1];

            if (nums[indx] % 2 == 0) {
                sum -= nums[indx];
            }
            nums[indx] = val + nums[indx];
            if (nums[indx] % 2 == 0) {
                sum += nums[indx];
            }
            result[i]= sum;

        }

        return  result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[][] queries = { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } };
        int[] result = sumEvenAfterQueries1(nums, queries);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }

}