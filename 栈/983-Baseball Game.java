public class Solution {
    /**
     * @param ops: the list of operations
     * @return:  the sum of the points you could get in all the rounds
     */
    public int calPoints(String[] ops) {
        // Write your code here
        // 判空
        if (ops == null || ops.length <= 0) return 0;
        // 利用栈保存当前所有游戏分数，根据不同的操作对栈中的分数进行处理
        // 使用sum保存当前游戏总分
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String string = ops[i];
            if (string.equals("C")){
                // “C”操作模拟
                int last = stack.pop();
                sum -= last;
            } else if (string.equals("D")){
                // “D”操作模拟
                int curr = 2*stack.peek();
                sum += curr;
                stack.push(curr);
            } else if (string.equals("+")){
                // “+”操作模拟
                int last = stack.pop();
                int curr = last + stack.peek();
                sum += curr;
                stack.push(last);
                stack.push(curr);
            } else {
                // 分数值
                int curr = Integer.valueOf(string);
                sum += curr;
                stack.push(curr);
            }
        }
        return sum;
    }
}