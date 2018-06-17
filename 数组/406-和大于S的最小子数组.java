public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        // 基本思路：双指针，不断移动指针的位置，并且指针之间的所有数的和一直大于等于s，
        // 求两个指针之间的最短距离
        // 判空
        if (nums == null || nums.length <= 0) return -1;
        // 求和
        int sum = 0;
        // 双指针
        int left = 0, right = 0;
        // 上限
        int length = nums.length+1;
        // 先找到前n个数的和大于等于s
        while (sum < s && right < nums.length) sum += nums[right++];
        // 向后移动right指针，并根据和sum移动left指针
        while (left < right && right < nums.length){
            length = Math.min(length,right-left);
            sum += nums[right++];
            while (sum - nums[left] >= s && left < right) sum -= nums[left++];
        }
        // right指针移动到最后，继续求最后的值
        length = Math.min(length,right-left);
        // 根据sum的值判断是否无解
        return sum < s ? -1 : length;
    }
}