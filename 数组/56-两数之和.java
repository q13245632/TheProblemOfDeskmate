public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        // 判空
        if (numbers == null || numbers.length <= 1) return null;
        // 利用map保存当前遍历过的元素及其索引
        Map<Integer,Integer> map = new HashMap<>();
        // 遍历
        for (int i = 0; i < numbers.length; i++) {
            // 查找之前是否存在与当前值的和为target的数
            if (map.containsKey(target-numbers[i]) && map.get(target-numbers[i]) != i){
                return new int[]{map.get(target-numbers[i]),i};
            }
            map.put(numbers[i],i);
        }
        return null;
    }
}