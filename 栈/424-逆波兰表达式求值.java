public class Solution {
    /**
     * @param tokens: The Reverse Polish Notation
     * @return: the value
     */
    public int evalRPN(String[] tokens) {
        // write your code here
        // 判空
        if (tokens == null ||tokens.length <= 0) return 0;
        // 利用栈模拟，不需要判断是否是合理的逆波兰表达式
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String string = tokens[i];
            if (string.equals("+")){
                // 如果是+，则将栈顶的两个值进行相加，并保存到栈中
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            } else if (string.equals("-")){
                // 如果是-，则将栈顶的两个值进行相减，并保存到栈中
                // 注意要用弹出的第二个数减去第一个数
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if (string.equals("*")){
                // 如果是*，则将栈顶的两个值进行相乘，并保存到栈中
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
            } else if (string.equals("/")){
                // 如果是/，则将栈顶的两个值进行相除，并保存到栈中
                // 注意要用弹出的第二个数除以第一个数
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            } else {
                // 其他数则直接保存到栈中
                stack.push(Integer.valueOf(string));
            }
        }
        // 弹出最后的计算结果
        return stack.peek();
    }
}