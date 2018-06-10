public class Solution {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        // 判空
        if (nums == null || nums.size() <= 0) return;
        // 双指针
        int first = 0, last = nums.size()-1;
        // 比较列表首尾的数大小，将第一个大的数移动到最后，并删除第一个元素
        while (nums.get(first) >= nums.get(last)){
            nums.add(nums.get(first));
            nums.remove(first);
        }
    }
}