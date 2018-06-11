public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        // 判空
        if (prices == null || prices.length <= 0) return 0;
        // 记录最大的差值
        int max = Integer.MIN_VALUE;
        // 记录当前的最小值
        int[] min = new int[prices.length];
        // 赋初值
        for (int i = 0; i < min.length; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        // 动态规划计算之前的最小价格
        min[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min[i] = Math.min(min[i-1],prices[i-1]);
        }
        // 计算最大利润
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max,prices[i] - min[i]);
        }
        return max;
    }
}