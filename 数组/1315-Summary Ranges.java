public class Solution {
    /**
     * @param nums:  a sorted integer array without duplicates
     * @return: the summary of its ranges
     */
    public List<String> summaryRanges(int[] nums) {
        // Write your code here
        // 保存结果
        List<String> result = new ArrayList<>();
        // 判空
        if (nums == null || nums.length <= 0) return result;
        // 双指针，分别指向范围的起止位置
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 寻找该范围的终止位置
            while (i<nums.length && nums[i]-end==1){
                end = nums[i];
                i ++;
            }
            // 起止位置不相等，加入范围
            if (end != start){
                result.add(start + "->" + end);
            } else {
                // 起止位置相等，加入个数
                result.add(String.valueOf(start));
            }
            // 新的范围的起止位置
            if (i<nums.length){
                start = nums[i];
                end = nums[i];
            }
        }
        // 判断数组最后一个位置是否为单个数，并加入结果
        if (start == end){
            result.add(String.valueOf(start));
        }
        return result;
    }
}