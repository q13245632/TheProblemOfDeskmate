public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        // 判空
        if (nums == null || nums.length <= 0) return 0;
        // pos表示当前应该插入的位置，
        // pre指pos位置前面的值
        int pos = 1, pre = 0;
        for (int i = 1; i < nums.length; i++) {
            // 当前值等于pre的值，则继续循环
            if (nums[pre] == nums[i]) continue;
            else {
                // 不同的值
                // 赋值后进行移动
                pre = pos;
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}