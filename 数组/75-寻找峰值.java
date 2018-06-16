public class Solution {
    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        // 判空
        if (A == null || A.length <= 0) return -1;
        // 区间，防止出界
        int left = 1, right = A.length - 2;
        while (left + 1 < right){
            int mid = left + (right-left)/2;
            // 向大数方向逼近
            if (A[mid] < A[mid-1]){
                right = mid;
            } else if (A[mid] < A[mid+1]){
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[left] < A[right]){
            return right;
        } else {
            return left;
        }
    }
}