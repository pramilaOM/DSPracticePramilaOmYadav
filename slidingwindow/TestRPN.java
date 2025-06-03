import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

class evalRPNTest {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int result = 0;

        Map<String, BiFunction<Integer, Integer, Integer>> mp = new HashMap<>();
        mp.put("+", (a, b) -> a + b);
        mp.put("-", (a, b) -> a - b);
        mp.put("*", (a, b) -> (int) ((long) a * (long) b));
        mp.put("/", (a, b) -> a / b);

        for (String s : tokens) {
            if (mp.containsKey(s)) {
                int b = st.pop();
                int a = st.pop();

                result = mp.get(s).apply(a, b);
                st.push(result);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }

}

public class TestRPN {

    public static void main(String[] args) {
        evalRPNTest sol = new evalRPNTest();

        test(sol, new String[] { "2", "1", "+", "3", "*" }, 9);
        test(sol, new String[] { "4", "13", "5", "/", "+" }, 6);
        test(sol, new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }, 22);
    }

    private static void test(evalRPNTest sol, String[] tokens, int expected) {
        int result = sol.evalRPN(tokens);
        System.out.println("Input: " + String.join(" ", tokens));
        System.out.println("Expected: " + expected + ", Got: " + result);
        System.out.println(result == expected ? "PASS\n" : "FAIL\n");
    }
}
