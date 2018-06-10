public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: True if and only if the matrix is Toeplitz
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) return true;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) return false;
            }
        }
        return true;
    }
}