public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        // 二分查找
        if (nums == null || nums.length <= 0) return -1;
        // 双指针
        int left = 0, right = nums.length-1;
        while (left <= right){
            // 计算中点
            int mid = left + (right-left)/2;
            // 根据中点值移动左右指针
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                // 找到target，寻找第一次出现的位置
                while (mid >= 0 && nums[mid] == target) mid --;
                return mid+1;
            }
        }
        return -1;
    }
}