public class Solution {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: the maximum average value
     */
    public double findMaxAverage(int[] nums, int k) {
        // Write your code here
        // 判空
        if (nums == null || nums.length <= 0) return 0;
        // 判断k是否合法
        if (k <= 0) return 0;
        // 取最小的k和nums.length
        k = Math.min(k,nums.length);
        int sum = 0; // 记录当前k个数的和
        double max = Double.MIN_VALUE;// 记录最大的平均值
        // 首先记录前k个数的和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        // 求前k个数的平均值
        max = Math.max(max,1.0 * sum / k);
        // 依次向后移动，减去最前的数，加上后面的数，并求平均值
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i-k];
            sum += nums[i];
            max = Math.max(max,1.0 * sum / k);
        }
        return max;
    }
}