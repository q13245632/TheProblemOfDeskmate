public class Solution {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        // 判空
        if (heights == null || heights.length <= 0) return 0;
        // 找到海拔最高的地方，分别计算左右两边可以接的雨水量
        int max = Integer.MIN_VALUE, pos = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > max) {
                max = heights[i];
                pos = i;
            }
        }
        int result = 0;
        // 计算最高海拔左边的雨水量
        int left = heights[0];
        for (int i = 0; i < pos; i++) {
            // 交换当前最左边最高的海拔
            if (left < heights[i]) left = heights[i];
            else result += left - heights[i];
        }
        // 计算最高海拔右边的雨水量
        int right = heights[heights.length-1];
        for (int i = heights.length-1; i > pos ; i--) {
            // 交换当前最右边最高的海拔
            if (right < heights[i]) right = heights[i];
            else result += right - heights[i];
        }
        return result;
    }
}