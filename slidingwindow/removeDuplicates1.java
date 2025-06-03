import java.util.Stack;

class removeDuplicates1 {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }

        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("azxxzy"));

    }
}
