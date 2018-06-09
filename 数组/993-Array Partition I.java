public class Solution {
    /**
     * @param nums: an array
     * @return: the sum of min(ai, bi) for all i from 1 to n
     */
    public int arrayPairSum(int[] nums) {
        // Write your code here
        // 判空
        if (nums == null || nums.length <= 0) return -1;
        // 记录和
        int sum = 0;
        // 对数组排序
        Arrays.sort(nums);
        // 求相邻两个数的最小值
        for (int i = 0; i < nums.length; i+=2) {
            sum += Math.min(nums[i],nums[i+1]);
        }
        return sum;
    }
}