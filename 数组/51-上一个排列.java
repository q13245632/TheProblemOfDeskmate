public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() <= 0) return nums;
        int pos = -1;
        for (int i = nums.size()-2; i >= 0; i--) {
            if (nums.get(i) > nums.get(i+1)){
                pos = i;
                break;
            }
        }
        if (pos == -1){
            reverse(nums, 0, nums.size()-1);
        } else {
            for (int i = nums.size()-1; i >= 0; i--) {
                if (nums.get(i)<nums.get(pos)){
                    int temp = nums.get(pos);
                    nums.set(pos, nums.get(i));
                    nums.set(i, temp);
                    reverse(nums, pos+1, nums.size()-1);
                    break;
                }

            }
        }
        return nums;
    }

    private void reverse(List<Integer> nums, int start, int end){
        while (start < end){
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start ++;
            end --;
        }
    }
}