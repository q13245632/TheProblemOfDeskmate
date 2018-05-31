public class Solution {
    /**
     * @param nums: a list of n integers
     * @return: true if there is a 132 pattern or false
     */
    public boolean find132pattern(int[] nums) {
        // write your code here
        // 判空
        if (nums == null || nums.length <= 0) return false;
        // 栈
        Stack<Integer> stack = new Stack<>();
        // 记录当前最小的数
        int min = Integer.MAX_VALUE;
        // 遍历
        for (int num :
                nums) {
            if (num <= min){
                // 记录当前最小的数
                min = Math.min(min,num);
            } else {
                // 当前的数大于最小值，则判断是否是132模式
                // 栈顶为最小的值
                while (!stack.isEmpty()){
                    // 如果当前值小于等于最小值，则肯定不是132模式
                    if (stack.peek() >= num) break;
                    stack.pop(); // 弹出最小值
                    // 判断栈中最大的值与当前值的关系
                    // 如果当前值小于最大值，那么是132模式
                    if (stack.pop() > num) return true;
                }
                // 保存132模式中最大的值
                stack.push(num);
                // 保存132模式中最小的值
                stack.push(min);
            }
        }
        return false;
    }
}