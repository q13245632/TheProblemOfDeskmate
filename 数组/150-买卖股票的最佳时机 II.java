public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        // 多次交易，找到每个连续子数组的最小和最大，求和即可
        // 即找到多个连续数值的波谷和波峰，加上差值即可
        if (prices == null || prices.length <= 0) return 0;
        int sum = 0;
        int min = prices[0], max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 找到波峰，即最大值
            while (i < prices.length && prices[i] > prices[i-1]) i ++;
            max = prices[i-1];
            sum += max - min; // 加上差值
            // 新的波谷，最小值
            if (i < prices.length) min = prices[i];
        }
        return sum;
    }
}