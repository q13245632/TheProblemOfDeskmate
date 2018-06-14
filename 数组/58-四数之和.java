public class Solution {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        // 类似threeSum
        List<List<Integer>> result = new ArrayList<>();
        // 判空
        if (numbers == null || numbers.length <= 3) return result;
        Arrays.sort(numbers); // 排序
        // 第一层循环
        for (int i = 0; i < numbers.length-3; i++) {
            // 去重
            if (i!=0 && numbers[i]==numbers[i-1]) continue;
            // 第二层循环
            for (int j = i+1; j < numbers.length-2; j++) {
                // 去重
                if (j!=i+1 && numbers[j]==numbers[j-1]) continue;
                // 双指针，logN时间复杂度
                int left = j+1,right = numbers.length-1;
                while (left<right){
                    // 求和
                    int sum = numbers[i]+numbers[j]+numbers[left]+numbers[right];
                    // 判断
                    if (sum==target){
                        List<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[left]);
                        list.add(numbers[right]);
                        result.add(list);
                        while (left<right&&numbers[left]==numbers[left+1]) left++;
                        while (left<right&&numbers[right]==numbers[right-1]) right--;
                        left++;
                        right--;
                    } else if (sum<target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}