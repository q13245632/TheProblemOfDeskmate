public class Solution {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    // 调着调着就过了，真的很神奇，
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length <= 0) return 0;
        int far = A[0], temp = far;
        if (far >= A.length-1) return 1;
        int step = 0;
        for (int i = 1; i < A.length; i++) {
            step ++;
            if (far >= A.length-1) return step;
            for (int j = i; j <= temp; j++) {
                if (i <= far && far <= A[j]+j) far = A[j]+j;
            }
            temp = far;
        }
        return 0;
    }
}