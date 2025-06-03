import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MatrixDiagonalSort {

    public static int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> data = new HashMap<>();
        for (int i = 0; i < mat.length ; i++) {
            for (int j = 0; j < mat[0].length ; j++) {
                data.putIfAbsent((i - j), new PriorityQueue<>());
                data.get(i - j).add(mat[i][j]);
            }
        }
        for (int i = 0; i < mat.length ; i++) {
            for (int j = 0; j < mat[0].length ; j++) {
                mat[i][j] = data.get(i - j).poll();
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
        int[][] res = diagonalSort(mat);
        for (int[] ans : res) {
           System.out.println(Arrays.toString(ans));
        }

    }

}
