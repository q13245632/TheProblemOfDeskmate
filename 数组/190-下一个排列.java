public class Solution {
    /**
     * @param nums: An array of integers
     * @return: nothing
     */
    // 讲解：http://www.cnblogs.com/grandyang/p/4428207.html
    public void nextPermutation(int[] nums) {
        // write your code here
        int i,j,len = nums.length;
        for (i = len-2; i >= 0; i--) {
            if (nums[i+1] > nums[i]){
                for (j = len-1; j > i; j--) {
                    if (nums[j] > nums[i]) break;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                reverse(nums,i+1,len-1);
                return;
            }
        }
        reverse(nums,0,len-1);
    }

    private void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}