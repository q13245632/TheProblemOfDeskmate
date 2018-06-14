public class Solution {
    /**
     * @param nums: the given array
     * @param k: the window size
     * @return: the sum of the count of unique elements in each window
     */
    public int slidingWindowUniqueElementsSum(int[] nums, int k) {
        // write your code here
        // 判空
        if (nums == null || nums.length <= 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
                count ++;
            } else {
                map.put(nums[i],map.get(nums[i])+1);
                if (map.get(nums[i]) == 2){
                    count --;
                }
            }
            if (i >= k-1){
                result += count;
                map.put(nums[i+1-k],map.get(nums[i+1-k])-1);
                if (map.get(nums[i+1-k]) == 1){
                    count ++;
                } else if (map.get(nums[i+1-k]) == 0){
                    map.remove(nums[i+1-k]);
                    count --;
                }
            }
        }
        if (nums.length < k) return count;
        return result;
    }
}