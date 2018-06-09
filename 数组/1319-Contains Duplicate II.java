public class Solution {
    /**
     * @param nums: the given array
     * @param k: the given number
     * @return:  whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Write your code here
        // 判空
        if (nums == null || nums.length <= 0) return false;
        // 利用map记录
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            // 判断重复的数的两个索引的差
            if (map.containsKey(curr)){
                if (i - map.get(curr) <= k){
                    return true;
                }
            }
            // 更新索引，或者插入map中原来不存在的数
            map.put(curr,i);
        }
        return false;
    }
}