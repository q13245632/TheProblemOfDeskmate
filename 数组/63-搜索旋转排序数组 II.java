public class Solution {
    /**
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length <= 0) return false;
        int left = 0, right = A.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (A[mid] == target) return true;
            if (A[left]<A[mid]){
                if (A[left]<=target && target < A[mid]){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else if (A[left]>A[mid]){
                if (A[mid]<target && target <= A[right]){
                    left = mid+1;
                } else {
                    right=mid-1;
                }
            } else {
                left++;
            }
        }
        return false;
    }
}