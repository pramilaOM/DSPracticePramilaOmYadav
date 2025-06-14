class countNegatives1 {
    public static int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int row = m - 1;
        int column = 0;

        int result = 0;
        while (row >= 0 && column < n) {
            if (grid[row][column] >= 0) {
                column++;
            } else {
                result = result + n - column;
                row--;
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[][] grid = { { 3, 2 }, { 1, 0 } };
        System.out.println(countNegatives(grid));
    }
}