public class Solution {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: the number of subarrays where the product of all the elements in the subarray is less than k
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Write your code here
        // 思路：http://www.cnblogs.com/grandyang/p/7753959.html
        if (nums == null || nums.length <= 0) return 0;
        int pro = 1, count = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            pro *= nums[i];
            while (left <= i && pro >= k) pro /= nums[left++];
            count += i-left+1;
        }
        return count;
    }
}