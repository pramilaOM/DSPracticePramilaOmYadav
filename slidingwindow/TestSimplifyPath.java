import java.util.ArrayList;
import java.util.List;

public class TestSimplifyPath {

    public String simplifyPath(String path) {
        List<String> stack = new ArrayList<>();
        String[] tokens = path.split("/");

        for (String token : tokens) {
            if (token.isEmpty() || token.equals(".")) {
                continue;

            } else if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.remove(stack.size()-1);
                }

            } else {
                stack.add(token);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/").append(str);
        }
        return sb.length() == 0 ? "/" : sb.toString();

    }

    public static void main(String[] args) {
        TestSimplifyPath sol = new TestSimplifyPath();

        test(sol, "/home/", "/home");
        test(sol, "/home//foo/", "/home/foo");
        test(sol, "/home/user/Documents/../Pictures", "/home/user/Pictures");
        test(sol, "/../", "/");
        test(sol, "/.../a/../b/c/../d/./", "/.../b/d");
        test(sol, "/a/./b/../../c/", "/c");
        test(sol, "/a/../../b/../c//.//", "/c");
        test(sol, "/a//b////c/d//././/..", "/a/b/c");
        test(sol, "/.", "/");
        test(sol, "/..hidden", "/..hidden");
    }

    private static void test(TestSimplifyPath sol, String input, String expected) {
        String result = sol.simplifyPath(input);
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Expected: \"" + expected + "\", Got: \"" + result + "\"");
        System.out.println(result.equals(expected) ? "PASS\n" : "FAIL\n");
    }
}
