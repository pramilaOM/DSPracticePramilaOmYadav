public class reverseArray {

    public static void main(String[] args) {
        int[] matrix = { 1, 2, 3, 4, 5, 6, 7, 8 };
        reverse(matrix);
        for (int j : matrix) {
        System.out.print(j + " ");
        }

    }

    private static void reverse(int[] matrix) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;
            left ++;
            right--;
        }

    }
}
