public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        // 判空
        if (A == null || A.length <= 0) return B;
        if (B == null || B.length <= 0) return A;
        // 两个数组的长度
        int len_A = A.length, len_B = B.length;
        // 合并后的结果
        int[] result = new int[len_A+len_B];
        // 两个数组的指针
        int a = 0, b = 0;
        // 结果的指针
        int pos = 0;
        // 遍历，根据两数组当前值大小移动指针
        while (a < len_A && b < len_B){
            if (A[a] < B[b]){
                // 移动数值小的指针
                result[pos++] = A[a++];
            } else {
                result[pos++] = B[b++];
            }
        }
        // 将较长的数组的值复制到结果中
        while (a < len_A) result[pos++] = A[a++];
        while (b < len_B) result[pos++] = B[b++];
        return result;
    }
}