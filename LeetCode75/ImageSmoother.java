package LeetCode75;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        // create a row and a column for checking all 8 direction
        int[] drow = { -1, 0, 1, 0, -1, -1, 1, 1 };
        int[] dcol = { 0, 1, 0, -1, -1, 1, -1, 1 };
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 1;
                int sum = img[i][j];
                // checking all 8 direction
                for (int k = 0; k < 8; k++) {
                    int row = i + drow[k];
                    int col = j + dcol[k];
                    if (row >= 0 && row < m && col >= 0 && col < n) {
                        count++;
                        sum += img[row][col];
                    }

                }
                ans[i][j] = sum / count;
            }
        }
        return ans;
    }
    /*
     * int rows = img.length;
     * int cols = img[0].length;
     * int[][] result = new int[rows][cols];
     * 
     * for (int i = 0; i < rows; ++i) {
     * for (int j = 0; j < cols; ++j) {
     * int totalSum = 0;
     * int count = 0;
     * 
     * for (int x = Math.max(0, i-1); x < Math.min(rows, i+2); ++x) {
     * for (int y = Math.max(0, j-1); y < Math.min(cols, j+2); ++y) {
     * totalSum += img[x][y];
     * count += 1;
     * }
     * }
     * 
     * result[i][j] = totalSum / count;
     * }
     * }
     * 
     * return result;
     */
}
