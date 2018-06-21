public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        // 类似三数之和
        if (numbers == null || numbers.length <= 0) return -1;
        Arrays.sort(numbers);
        int diff = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length-2; i++) {
            int left= i+1, right = numbers.length-1;
            while (left<right){
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (Math.abs(sum-target) < diff){
                    diff = Math.abs(sum-target);
                    result = sum;
                } else if (sum > target){
                    right--;
                } else if (sum < target){
                    left++;
                } else {
                    return sum;
                }
            }
        }
        return result;
    }
}