public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        // 类似连续子数组最大和
        if (nums == null || nums.size() <= 0) return 0;
        int curr = nums.get(0);
        int min = curr;
        for (int i = 1; i < nums.size(); i++) {
            curr = Math.min(curr + nums.get(i),nums.get(i));
            min = Math.min(curr,min);
        }
        return min;
    }
}