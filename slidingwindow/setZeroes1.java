class setZeroes1 {
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        boolean firstRow = false;
        boolean firstColum = false;

        for (int i = 0; i < column; i++) {
            if (matrix[i][0] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            if (matrix[0][i] == 0) {
                firstColum = true;
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {

                    matrix[i][j] = 0;
                }
            }
        }

        if (firstColum) {
            for (int i = 0; i < column; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstRow) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }

        }

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setZeroes(matrix);
        for (int[] n : matrix) {
            for (int v : n) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

    }
}