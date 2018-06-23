public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        // 判空
        if (A == null || A.length <= 0) return false;
        // 贪心，记录能够达到的最远距离，和最后的位置比较，
        int far = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= far && far <= A[i]+i) far = A[i]+i;
        }
        return far>=A.length-1;
    }
}