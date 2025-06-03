public class TrapWater {
    public static int trap(int[] height) {
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        int[] result = new int[size];
        int sum = 0;
        leftMax[0] = height[0];
        rightMax[size - 1] = height[size - 1];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < size; i++) {
            result[i] = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (result[i] > 0) {
                sum = sum + result[i];
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int output = trap(height);
        System.out.println(output);

    }
}
