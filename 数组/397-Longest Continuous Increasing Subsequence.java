public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        // 判空
        if (A == null || A.length <= 0) return 0;
        // max指最大值
        // increase指从左到右的连续递增子序列长度
        // deincrease值从右到左的连续递增子序列长度（从左到右则是连续递减的）
        int max = 1, increase = 1, deincrease = 1;
        for (int i = 1; i < A.length; i++) {
            // 从左到右的连续递增
            if (A[i] > A[i-1]) increase ++;
            else increase = 1;
            // 从左到右的连续递减
            if (A[i] < A[i-1]) deincrease ++;
            else deincrease = 1;
            // 求最大
            max = Math.max(max,Math.max(increase,deincrease));
        }
        return max;
    }
}