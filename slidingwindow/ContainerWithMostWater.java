public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(area, ans);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;

    }

    public static void main(String[] args) {

        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.print(maxArea(height));

    }
}