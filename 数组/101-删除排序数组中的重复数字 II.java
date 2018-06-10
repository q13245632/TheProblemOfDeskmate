public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        // 判空
        if (nums == null || nums.length <= 0) return 0;
        // 类似第100题，使用一个count记录目前有多少的重复值即可
        int pos = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[pos]){
                if (count < 2){
                    nums[++pos] = nums[i];
                    count ++;
                }
            } else {
                nums[++pos] = nums[i];
                count = 1;
            }
        }
        return pos+1;
    }
}