public class Solution {
    /**
     * @param nums:  an array of n integers
     * @param target: a target
     * @return: the number of index triplets satisfy the condition nums[i] + nums[j] + nums[k] < target
     */
    public int threeSumSmaller(int[] nums, int target) {
        // Write your code here
        // 类似三数之和，排序后使用双指针
        if (nums == null || nums.length <= 0) return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i+1, right = nums.length-1;
            while (left<right){
                if (nums[left] + nums[right] + nums[i] < target){
                    count += (right-left);
                    left ++;
                } else {
                    right --;
                }
            }
        }
        return count;
    }
}