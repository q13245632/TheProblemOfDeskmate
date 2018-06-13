public class Solution {
    /**
     * @param heights: a vector of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        // 判空
        if (heights == null || heights.length < 2) return 0;
        int max = 0;
        // 双指针
        int left = 0 , right = heights.length - 1;
        while (left < right) {
            // 计算容器面积
            max = Math.max(max, (right - left) * Math.min(heights[left], heights[right]));
            // 向大的方向移动
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}