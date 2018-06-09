public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        // 简单的动态规划
        // 剑指原理，看讲解
        if (nums == null || nums.length <= 0) return 0;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i]+sum,nums[i]);
            max = Math.max(max,sum);
        }
        return max;
    }
}