public class Solution {
    /**
     * @param A: An integer array
     * @param B: An integer array
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        // 计算最小差，则需要找到两个数组中最接近或者相等的两个数
        // 判空
        if (A == null || A.length <= 0 || B == null || B.length <= 0) return 0;
        // 进行排序
        Arrays.sort(A);
        Arrays.sort(B);
        int a = 0, b = 0, max = Integer.MAX_VALUE;
        // 遍历，找到两个数组中最接近的数，
        // 排序数组中应该小的向大的逐个逼近
        while (a<A.length&&b<B.length){
            max = Math.min(max,Math.abs(A[a]-B[b]));
            if (A[a] < B[b]){
                a++;
            } else {
                b++;
            }
        }
        return max;
    }
}