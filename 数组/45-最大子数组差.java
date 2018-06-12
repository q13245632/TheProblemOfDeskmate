public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        // 判空
        if (nums == null || nums.length <= 1) return 0;
        int len = nums.length;
        // 利用四个数组
        // 从左最大子数组left_max，最小子数组left_min
        // 从右最大子数组right_max, 最小子数组right_min
        int[] left_max = new int[nums.length];
        int[] left_min = new int[nums.length];
        int[] right_max = new int[nums.length];
        int[] right_min = new int[nums.length];
        // 初始化数组
        left_max[0] = nums[0];
        left_min[0] = nums[0];
        right_max[len-1] = nums[len-1];
        right_min[len-1] = nums[len-1];
        // 更新数组
        int left_sum = nums[0];
        int right_sum = nums[len-1];
        int leftMin = 0, leftMax = 0;
        int rightMin = 0, rightMax = 0;
        for (int i = 1; i < nums.length; i++) {
            // 更新left_min和left_max
            leftMin = Math.min(left_sum,leftMin);
            leftMax = Math.max(left_sum,leftMax);
            left_sum += nums[i];
            left_min[i] = Math.min(left_min[i-1],left_sum-leftMax);
            left_max[i] = Math.max(left_max[i-1],left_sum-leftMin);
        }
        for (int i = nums.length-2; i >= 0; i--) {
            // 更新right_min和right_max
            rightMin = Math.min(rightMin,right_sum);
            rightMax = Math.max(rightMax,right_sum);
            right_sum += nums[i];
            right_min[i] = Math.min(right_min[i+1],right_sum-rightMax);
            right_max[i] = Math.max(right_max[i+1],right_sum-rightMin);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max,Math.max(Math.abs(right_max[i+1]-left_min[i]),
                    Math.abs(left_max[i] - right_min[i+1])));
        }
        return max;
    }
}