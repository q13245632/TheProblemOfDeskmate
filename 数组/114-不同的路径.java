public class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // 判断m和n的大小
        // 如果m和n中有一个为1，那么从左上角到右下角就只有1种
        if (m <= 1 || n <= 1) return 1;
        // 动态规划
        // 全局结果
        int[][] result = new int[m][n];
        // 初始化状态
        for (int i = 0; i < m; i++) {
            // 在第一列只有一种路径
            result[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            // 在第一行只有一种路径
            result[0][i] = 1;
        }
        // 只能从上或者从左达到该网格
        // 所以，到达某网格的路径总数等于从上到达该网格和从左达到该网格的路径之和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // result[i-1][j]代表从上到达该网格的路径
                // result[i][j-1]代表从左到达该网格的路径
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }
        // 返回最后结果
        return result[m-1][n-1];
    }
}