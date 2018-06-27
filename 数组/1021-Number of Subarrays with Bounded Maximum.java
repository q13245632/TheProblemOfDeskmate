public class Solution {
    /**
     * @param A: an array
     * @param L: an integer
     * @param R: an integer
     * @return: the number of subarrays such that the value of the maximum array element in that subarray is at least L and at most R
     */
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        // Write your code here
        if (A == null || A.length <= 0) return 0;
        int count = 0;
        int left = -1, right = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= L) right = i;
            if (A[i] > R) left = i;
            count += right-left;
        }
        return count;
    }
}