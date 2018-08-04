public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The majority number
     */
    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here
        if (nums.size() < k) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n :
                nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
            if (map.size() >= k){
                removeKey(map);
            }
        }
        if (map.size() <= 0) return -1;
        for (int key: map.keySet()) map.put(key, 0);
        for (int i:nums) {
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
        }
        int max = 0, result = 0;
        for (int key :
                map.keySet()) {
            if (map.get(key) > max){
                max = map.get(key);
                result = key;
            }
        }
        return result;
    }

    private void removeKey(Map<Integer, Integer> map) {
        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList<>();
        for (int key :
                set) {
            map.put(key, map.get(key)-1);
            if (map.get(key) == 0) list.add(key);
        }
        for (int i :
                list) {
            map.remove(i);
        }
    }
}