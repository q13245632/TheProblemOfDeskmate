public class Solution {
    /**
     * @param num: The arry you should handle
     * @return: Return the array
     */
    public int[] getPreviousNumber(int[] num) {
        // Write your code here
        // 判空
        if (num == null || num.length <= 0) return new int[0];
        // 记录最后的结果
        int[] result = new int[num.length];
        // 利用栈判断当前数值是否小于后面的数，栈中保存的是数组的索引，并不是数
        Stack<Integer> stack = new Stack<>();
        for (int i = num.length-1; i >= 0; i--) {
            // 从后向前遍历
            int curr = num[i];
            // 栈为空，则将当前数组的索引入栈
            if (stack.isEmpty()){
                stack.push(i);
            } else {
                // 判断当前数与栈中索引对应的数的大小，如果小于，则记录结果
                while (!stack.isEmpty() && curr < num[stack.peek()]){
                    result[stack.pop()] = curr;
                }
                // 将当前数的索引入栈
                stack.push(i);
            }
        }
        // 如果栈中还有索引没有更新，说明他们前面并没有数比他们小，直接用原来的数代替
        while (!stack.isEmpty()){
            result[stack.peek()] = num[stack.pop()];
        }
        return result;
    }
}