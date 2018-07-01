public class Solution {
    /**
     * @param arr: The given matrix
     * @return: Return the mininum sum
     */
    public long minimumSubmatrix(int[][] arr) {
        // Write your code here
        if (arr == null || arr.length <= 0 || arr[0].length <= 0) return 0;
        int rows = arr.length, cols = arr[0].length;
        long result = Long.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result = Math.min(arr[i][j],result);
            }
        }
        long[][] colSum = new long[201][201];
        for (int i = 1; i < rows+1; i++) {
            for (int j = 1; j < cols+1; j++) {
                colSum[i][j] = arr[i-1][j-1] + colSum[i-1][j];
            }
        }
        for (int i = 0; i < rows+1; i++) {
            for (int j = i+1; j < rows+1; j++) {
                long[] temp = new long[cols+1];
                for (int k = 0; k < temp.length; k++) {
                    temp[k] = colSum[j][k] - colSum[i][k];
                }
                long cur = temp[1];
                for (int k = 2; k < temp.length; k++) {
                    cur = Math.min(cur+temp[k],temp[k]);
                    result = Math.min(cur,result);
                }
            }
        }
        return  result;
    }
}