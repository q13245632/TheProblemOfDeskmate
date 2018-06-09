public class Solution {
    /**
     * @param nums: a integer array
     * @return: nothing
     */
    public void reverseArray(int[] nums) {
        // write your code here
        // 判空
        if (nums == null || nums.length <= 0) return;
        // 左右指针移动
        int left = 0, right = nums.length-1;
        // 循环交换元素
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }
}