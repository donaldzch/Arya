public class Image_Smoother_661 {
    public int[][] imageSmoother(int[][] M) {
        if (M == null) return null;
        int row = M.length;
        int col = M[0].length;

        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                for (int m = i - 1; m <= i + 1; m++) {
                    for (int n = j - 1; n <= j + 1; n++) {
                        if (m >= 0 && n >=0 && m <= row - 1 && n <= col - 1) {
                            result[i][j] += M[m][n];
                            count++;
                        }
                    }
                }
                result[i][j] = result[i][j]/count;
            }
        }

        return result;
    }
}
