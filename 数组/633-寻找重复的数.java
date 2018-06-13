public class Solution {
    /**
     * @param nums: an array containing n + 1 integers which is between 1 and n
     * @return: the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // write your code here
        // 判空
        // 讲解：http://www.cnblogs.com/grandyang/p/4843654.html
        if (nums == null || nums.length <= 0) return 0;
        // 双指针
        int left = 0, right = nums.length-1;
        // 二分法
        while (left < right){
            // 中点
            int mid = left + (right - left) / 2;
            // 记录数组中比中点小的数的个数
            int count = 0;
            // 统计个数
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) count++;
            }
            // 统计数小于中点，重复的值在大于中点的部分，否则在小于中点的部分
            if (count <= mid) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}