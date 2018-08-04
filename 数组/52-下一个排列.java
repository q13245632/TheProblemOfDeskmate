public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 0) return nums;
        for (int i = nums.length-1; i>=0; i--) {
            for (int j = nums.length-1; j>i; j--) {
                if (nums[i]<nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    reverse(nums,i+1,nums.length-1);
                    return nums;
                }
            }
        }
        reverse(nums, 0, nums.length-1);
        return nums;
    }

    private void reverse(int[] nums, int left, int right){
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }
}