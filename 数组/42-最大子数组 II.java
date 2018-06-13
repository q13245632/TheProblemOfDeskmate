public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        // 基本思路：从左边起最大连续子数组与从右边起最大连续子数组不重叠部分求最大和
        // 判空
        if (nums == null || nums.size() <= 0) return 0;
        int size = nums.size();
        // 左边最大连续子数组
        // 右边最大连续子数组
        int[] left = new int[size];
        int[] right = new int[size];
        int curr = 0;
        // 更新左边最大连续子数组
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int k = nums.get(i);
            curr = Math.max(curr+k,k);
            max = Math.max(max,curr);
            left[i] = max;
        }
        // 更新右边最大连续子数组
        curr = 0;
        max = Integer.MIN_VALUE;
        for (int i = size-1; i >= 0; i--) {
            int k = nums.get(i);
            curr = Math.max(curr+k,k);
            max = Math.max(max,curr);
            right[i] = max;
        }
        // 左右不重叠部分求最大和
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < size-1; i++) {
            result = Math.max(result,left[i] + right[i+1]);
        }
        return result;
    }
}