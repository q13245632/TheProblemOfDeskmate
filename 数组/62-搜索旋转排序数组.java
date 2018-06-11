public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        // 判空
        if (A == null || A.length <= 0) return -1;
        // 双指针
        int left = 0, right = A.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (A[mid] == target) return mid;
            // 从left到mid为递增
            if (A[mid] >= A[left]){
                // target在left和mid之间
                if (target < A[mid] && target >= A[left]){
                    right = mid-1;
                } else {
                    // target在mid和right之间
                    left = mid+1;
                }
            }
            // 从mid到right为递增
            if (A[mid] <= A[right]){
                // target在mid和right之间
                if (target > A[mid] && target <= A[right]){
                    left = mid+1;
                } else {
                    // target在left和mid之间
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}