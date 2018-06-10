public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        // 判空
        if (A == null || A.length <= 0) return 0;
        // 双指针
        int left = 0, right = A.length-1;
        // 判断数组的首尾大小
        if (A[left] >= target) return 0;
        if (A[right] < target) return right+1;
        // 二分查找
        while (left+1 < right){
            int mid = left + (right-left)/2;
            if (A[mid] < target){
                left = mid;
            } else if (A[mid] > target){
                right = mid;
            } else {
                // 找到与target相等的数
                return mid;
            }
        }
        return left+1;
    }
}