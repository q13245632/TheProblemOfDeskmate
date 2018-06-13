public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // 判空
        if (numbers == null || numbers.length < 3) return result;
        Arrays.sort(numbers); // 数组排序
        // 第一层循环
        for (int i = 0; i < numbers.length-2; i++) {
            // 二分查找寻找何为0-numbers[i]的两个数
            int left = i + 1, right = numbers.length-1;
            while (left < right){
                // 求和
                int sum = numbers[left] + numbers[right];
                // 判断
                if (sum + numbers[i] == 0){
                    list.add(numbers[i]);
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    result.add(list);
                    list = new ArrayList<>();
                    // 过滤left的相等值
                    while (left<right&&numbers[left]==numbers[left+1]) left++;
                    // 过滤right的相等值
                    while (left<right&&numbers[right]==numbers[right-1]) right--;
                    left ++;
                    right --;
                } else if (sum + numbers[i] > 0){
                    // 三者之和大于0，向小的值移动
                    right --;
                } else {
                    // 三者之和小于0，向大的值移动
                    left ++;
                }
            }
            // 过滤numbers[i]的相等值
            while (i<numbers.length-2&&numbers[i]==numbers[i+1]) i++;
        }
        return result;
    }
}