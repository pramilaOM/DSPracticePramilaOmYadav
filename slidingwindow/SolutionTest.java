import java.util.*;

public class SolutionTest {

    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> lost = new HashMap<>();

        for (int[] i : matches) {
            int data = i[1];
            lost.put(data, lost.getOrDefault(data, 0) + 1);
        }

        List<Integer> noLose = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();

        for (int[] i : matches) {
            int lose = i[1];
            int win = i[0];

            if (lost.get(lose) == 1) {
                oneLose.add(lose);
            }
            if (!lost.containsKey(win)) {
                noLose.add(win);
                lost.put(win, 2);
            }

        }

        Collections.sort(noLose);
        Collections.sort(oneLose);

        return Arrays.asList(noLose,oneLose);

    }

    public static void main(String[] args) {
        SolutionTest sol = new SolutionTest();

        int[][] matches1 = {
                { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 },
                { 4, 5 }, { 4, 8 }, { 4, 9 }, { 10, 4 }, { 10, 9 }
        };

        int[][] matches2 = {
                { 2, 3 }, { 1, 3 }, { 5, 4 }, { 6, 4 }
        };

        List<List<Integer>> result1 = sol.findWinners(matches1);
        System.out.println("Test Case 1 Output: " + result1);

        List<List<Integer>> result2 = sol.findWinners(matches2);
        System.out.println("Test Case 2 Output: " + result2);
    }

}
