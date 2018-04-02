package matrix.operation;

public class Reshape_the_Matrix_566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }

        int[][] matrix = new int[r][c];

        int k = 0; int l = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[k][l] = nums[i][j];
                l++;
                if (l == c) {
                    k++;
                    l = 0;
                }
            }
        }
        return matrix;
    }

    public int[][] matrixReshape1(int[][] nums, int r, int c) {

        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        int[][] matrix = new int[r][c];


        for (int i = 0; i < r*c; i++) {
            matrix[i/c][i%c] = nums[i/col][i%col];
        }
        return matrix;
    }
}
