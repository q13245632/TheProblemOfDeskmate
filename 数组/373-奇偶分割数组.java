public class Solution {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 0) return;
        // 双指针
        int left = 0, right = nums.length-1;
        while (left < right){
            // 找到左边第一个偶数
            while (left<right && nums[left]%2==1) left++;
            // 找到右边第一个奇数
            while (left<right && nums[right]%2==0) right--;
            if (left >= right) break;
            // 交换
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }
}