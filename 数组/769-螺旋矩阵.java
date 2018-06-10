public class Solution {
    /**
     * @param n: a Integer
     * @return: a spiral array
     */
    public int[][] spiralArray(int n) {
        // write your code here
        // 判空
        if (n <= 0) return null;
        // 保存结果
        int[][] result = new int[n][n];
        // 从1开始计数
        int start = 1;
        // 上下左右四个指针
        int top = 0, bottom = n-1, left = 0, right = n-1;
        // 循环
        while (start <= n*n){
            // 填充top行
            for (int i = left; i <= right; i++) {
                result[top][i] = start++;
            }
            top ++;
            // 填充right列
            for (int i = top; i <= bottom; i++) {
                result[i][right] = start++;
            }
            right --;
            // 填充bottom行
            for (int i = right; i >= left; i--) {
                result[bottom][i] = start++;
            }
            bottom --;
            // 填充left列
            for (int i = bottom; i >= top; i--) {
                result[i][left] = start++;
            }
            left ++;
        }
        return result;
    }
}