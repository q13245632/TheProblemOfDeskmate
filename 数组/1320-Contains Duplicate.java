public class Solution {
    /**
     * @param nums: the given array
     * @return: if any value appears at least twice in the array
     */
    public boolean containsDuplicate(int[] nums) {
        // Write your code here
        if (nums == null || nums.length <= 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}