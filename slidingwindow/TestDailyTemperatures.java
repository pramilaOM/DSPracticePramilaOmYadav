import java.util.Stack;

class TestDailyTemperatures {

    static class dailyTemperaturesTest {
        public int[] dailyTemperatures(int[] temperatures) {

            Stack<Integer> stack = new Stack<>();
            int size = temperatures.length;
            int[] result = new int[size];
            for (int i = size - 1; i >= 0; i--) {
                while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    result[i] = 0;
                } else {
                    result[i] = stack.peek() - i;
                }
                stack.push(i);
            }

            return result;

        }
    }

    public static void main(String[] args) {
        dailyTemperaturesTest sol = new dailyTemperaturesTest();

        test(sol, new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }, new int[] { 1, 1, 4, 2, 1, 1, 0, 0 });
        test(sol, new int[] { 30, 40, 50, 60 }, new int[] { 1, 1, 1, 0 });
        test(sol, new int[] { 30, 60, 90 }, new int[] { 1, 1, 0 });
        test(sol, new int[] { 90, 80, 70, 60 }, new int[] { 0, 0, 0, 0 });
    }

    private static void test(dailyTemperaturesTest sol, int[] temperatures, int[] expected) {
        int[] result = sol.dailyTemperatures(temperatures);
        System.out.print("Input:    ");
        printArray(temperatures);
        System.out.print("Expected: ");
        printArray(expected);
        System.out.print("Output:   ");
        printArray(result);
        System.out.println(java.util.Arrays.equals(result, expected) ? "PASS\n" : "FAIL\n");
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
