public class Solution {
    /**
     * @param nums: an array
     * @return: the shortest subarray's length
     */
    public int findUnsortedSubarray(int[] nums) {
        // Write your code here
       // 判空
        if (nums == null || nums.length <= 0) return 0;
        // 辅助数组
        int[] temp = new int[nums.length];
        // 复制原数组
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        // 排序
        Arrays.sort(temp);
        // 找到左边第一个不同的元素
        int left = 0, right = nums.length-1;
        while (left<=right && nums[left] == temp[left]) left ++;
        // 找到右边第一个不同的元素
        while (left<=right && nums[right] == temp[right]) right --;
        // 求间隔
        return right-left+1;
    }
}