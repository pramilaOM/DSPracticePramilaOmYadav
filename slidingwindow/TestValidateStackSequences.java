import java.util.Stack;

public class TestValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int m = pushed.length;
        int i = 0;
        int j = 0;

        while (i < m && j < m) {
            stack.push(pushed[i]);

            while(!stack.isEmpty() && j < m && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
            i++;

        }
        return stack.empty();

    }

    public static void main(String[] args) {
        TestValidateStackSequences sol = new TestValidateStackSequences();

        test(sol, new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 }, true);
        test(sol, new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 3, 5, 1, 2 }, false);
        test(sol, new int[] { 1 }, new int[] { 1 }, true);
        test(sol, new int[] { 1, 2 }, new int[] { 2, 1 }, true);
        test(sol, new int[] { 1, 2 }, new int[] { 1, 2 }, true);
        test(sol, new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 }, true);
        test(sol, new int[] { 1, 2, 3 }, new int[] { 2, 1, 3 }, true);
        test(sol, new int[] { 1, 2, 3 }, new int[] { 2, 3, 1 }, false);
        test(sol, new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 5, 4, 2, 1 }, true);
        test(sol, new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 5, 4, 1, 2 }, false);
    }

    private static void test(TestValidateStackSequences sol, int[] pushed, int[] popped, boolean expected) {
        boolean result = sol.validateStackSequences(pushed, popped);
        System.out.println("Input pushed: " + java.util.Arrays.toString(pushed));
        System.out.println("Input popped: " + java.util.Arrays.toString(popped));
        System.out.println("Expected: " + expected + ", Got: " + result);
        System.out.println(result == expected ? "PASS\n" : "FAIL\n");
    }
}
