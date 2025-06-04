import java.util.Arrays;
import java.util.Stack;

public class TestAsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int sum = a + stack.peek();

                if (sum < 0) {
                    stack.pop();
                } else if (sum > 0) {
                    a = 0;
                } else {
                    stack.pop();
                    a = 0;
                }
            }

            if (a != 0) {
                stack.push(a);
            }

        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TestAsteroidCollision sol = new TestAsteroidCollision();

        test(sol, new int[] { 5, 10, -5 }, new int[] { 5, 10 });
        test(sol, new int[] { 8, -8 }, new int[] {}); // both explode
        test(sol, new int[] { 10, 2, -5 }, new int[] { 10 });
        test(sol, new int[] { -2, -1, 1, 2 }, new int[] { -2, -1, 1, 2 }); // no collision
        test(sol, new int[] { 1, -1, -2, 2 }, new int[] { -2, 2 }); // initial pair explodes
        test(sol, new int[] { -5, -10, 5, 10 }, new int[] { -5, -10, 5, 10 }); // moving away
        test(sol, new int[] { 10, -10, 10, -10 }, new int[] {}); // all destroy
        test(sol, new int[] { 10, 5, -2, -20 }, new int[] { -20 }); // chain reaction
        test(sol, new int[] { -2, -1, -5, 4, 3 }, new int[] { -2, -1, -5, 4, 3 }); // no collision
    }

    private static void test(TestAsteroidCollision sol, int[] input, int[] expected) {
        int[] result = sol.asteroidCollision(input);
        System.out.println("Input:    " + Arrays.toString(input));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Output:   " + Arrays.toString(result));
        System.out.println(Arrays.equals(result, expected) ? "PASS\n" : "FAIL\n");
    }
}
