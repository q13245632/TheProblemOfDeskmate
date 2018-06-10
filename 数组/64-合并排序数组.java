public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        // 判空
        if (B == null || B.length <= 0 || n <= 0) return;
        // 双指针
        // 从后向前合并两个有序数组
        // 从最大的值开始向前移动，
        int pos = m+n-1, a = m-1, b = n-1;
        while (a>=0&&b>=0){
            if (A[a] >= B[b]){
                A[pos--] = A[a--];
            } else {
                A[pos--] = B[b--];
            }
        }
        while (a>=0) A[pos--] = A[a--];
        while (b>=0) A[pos--] = B[b--];
    }
}