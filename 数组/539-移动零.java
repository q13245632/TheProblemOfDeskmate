public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        // 判空
        if (nums == null || nums.length <= 0) return;
        // 双指针
        // pos表示目前非零元素应该插入的位置
        // index表示当前数组查找的位置
        int pos = 0, index = 0;
        // 遍历
        while (index < nums.length){
            // 依次找到非零元素的index
            while (index < nums.length && nums[index] == 0) index ++;
            // 判断结束条件
            if (index >= nums.length) break;
            // 将非零元素赋值到pos的位置，
            // 并向后移动pos和index指针的位置
            nums[pos++] = nums[index++];
        }
        // pos后面全部赋值为0
        for (int i = pos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}