import java.util.Stack;

public class TestValidParentheses {
    public boolean isValid(String s) {
        // Your implementation goes here

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }

                if ((c == ')' && stack.pop() != '(')  || (c == '}' && stack.pop() != '{') || (c == ']' && stack.pop() != '[')){
                    return false;

                }
            }
        }

        return stack.empty(); // placeholder
    }

    public static void main(String[] args) {
        TestValidParentheses sol = new TestValidParentheses();

        test(sol, "()", true);
        test(sol, "()[]{}", true);
        test(sol, "(]", false);
        test(sol, "([)]", false);
        test(sol, "{[]}", true);
        test(sol, "(", false);
        test(sol, "", true); // Optional: empty string can be considered valid
    }

    public static void test(TestValidParentheses sol, String input, boolean expected) {
        boolean result = sol.isValid(input);
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Expected: " + expected + ", Got: " + result);
        System.out.println(result == expected ? "PASS\n" : "FAIL\n");
    }
}
