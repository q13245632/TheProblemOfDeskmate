public class Solution {
    /**
     * @param nums: an integer array
     * @return: the maximum product
     */
    public int maximumProduct(int[] nums) {
        // Write your code here
        // 三个数乘积最大包括两种情况：（1）最大的三个正整数乘积；
        // （2）最小的两个负整数和最大的正整数乘积
        // 所以找到最大的三个数和最小的两个数，比较乘积即可
        if (nums == null || nums.length < 3) return 0;
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        int less_first = Integer.MAX_VALUE, less_second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr > first){
                third = second;
                second = first;
                first = curr;
            } else if (curr > second){
                third = second;
                second = curr;
            } else if (curr > third){
                third = curr;
            }
            if (curr < less_first){
                less_second = less_first;
                less_first = curr;
            } else if (curr < less_second){
                less_second = curr;
            }
        }
        return Math.max(first*second*third,first*less_first*less_second);
    }
}