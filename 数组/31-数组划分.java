public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        // 快排的数组切分
        // 判空
        if (nums == null || nums.length <= 0) return 0;
        // 双指针
        int left = 0, right = nums.length-1;
        // 循环
        while (left < right){
            // 找到左边第一个大于等于k的数
            while (left < right && nums[left] < k) left++;
            // 找到右边第一个小于k的数
            while (left < right && nums[right] >= k) right--;
            // 跳出循环的条件
            if (left >= right) break;
            // 交换两个数
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums[left]>=k?left:left+1;
    }
}