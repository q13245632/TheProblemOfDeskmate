public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        // 判空
        if (obstacleGrid == null || obstacleGrid.length <= 0
                || obstacleGrid[0].length <= 0) return 0;
        // 获取网格的行数和列数
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        // 如果0,0的位置是障碍，则直接返回0
        if (obstacleGrid[0][0] == 1) return 0;
        // 保存路径结果
        int[][] result = new int[m][n];
        // 初始化
        result[0][0] = 1;
        // 根据网格中位置的类型初始化不同的路径个数
        for (int i = 1; i < m; i++) {
            // 当位置是0，不是障碍物，路径个数等于从上到达的路径数
            if (obstacleGrid[i][0] == 0) result[i][0] = result[i-1][0];
            else if (obstacleGrid[i][0] == 1) result[i][0] = 0; // 如果是1，则直接为0
        }
        for (int i = 1; i < n; i++) {
            // 当位置是0，不是障碍物，路径个数等于从左到达的路径数
            if (obstacleGrid[0][i] == 0) result[0][i] = result[0][i-1];
            else if (obstacleGrid[0][i] == 1) result[0][i] = 0; // 如果是1，则直接为0
        }
        // 根据网格中位置的类型计算不同的路径个数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 当前位置是障碍物，则路径为0
                if (obstacleGrid[i][j] == 1) result[i][j] = 0;
                else {
                    // 当前位置不是障碍物，则到达某网格的路径总数等于从上到达该网格和从左达到该网格的路径之和
                    result[i][j] = result[i-1][j] + result[i][j-1];
                }
            }
        }
        return result[m-1][n-1];
    }
}