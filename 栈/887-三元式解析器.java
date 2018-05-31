public class Solution {
    /**
     * @param expression: a string, denote the ternary expression
     * @return: a string
     */
    public String parseTernary(String expression) {
        // write your code here
        if (expression == null || expression.length() <= 0) return expression;
        // 两个栈
        // num记录操作数
        // ops记录操作符号（其实可以不用这个）
        Stack<Character> num = new Stack<>();
        Stack<Character> ops = new Stack<>();
        // 从后往前开始处理（很重要）
        for (int i = expression.length()-1; i >= 0; i--) {
            // 记录当前的数
            char curr = expression.charAt(i);
            // 根据不同的字符进行不同的操作
            if (curr == ':') {
                ops.push(curr);
            } else if (curr == '?'){
                // 遇到？号，开始解析当前的三元操作符
                // 取问号前面的条件
                char condi = expression.charAt(i-1);
                // 取问号后面的数
                char pre = num.pop();
                // 取冒号后面的数
                char last = num.pop();
                // 根据条件进行判断
                if (condi == 'T'){
                    num.push(pre);
                } else {
                    num.push(last);
                }
                // 问号前面的条件数已经使用，所以i--；
                i --;
            } else {
                // 其他操作数，直接入栈
                num.push(curr);
            }
        }
        // 返回栈中的最后结果
        return String.valueOf(num.peek());
    }
}