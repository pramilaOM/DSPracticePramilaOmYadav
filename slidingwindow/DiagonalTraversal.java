import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraversal {
    public static int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, List<Integer>> data = new HashMap<>();
        int row = mat.length;
        int column = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int key = i + j;
                data.putIfAbsent(key, new ArrayList<>());
                data.get(key).add(mat[i][j]);

            }
        }
        int[] result = new int[row * column];
        int index = 0;
        for (int i = 0; i <= row + column - 2; i++) {
            List<Integer> eachRow = data.get(i);
            if (eachRow != null) {
                if (i % 2 == 0) {
                    Collections.reverse(eachRow);
                }
                for (int n : eachRow) {
                    result[index++] = n;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));

    }
}
