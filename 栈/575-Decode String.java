public class Solution {
    /**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        // 判空
        if (s == null || s.length() <= 0) return s;
        // 利用栈保存前面的信息
        Stack<String> stack = new Stack<>();
        int num = 0; // 记录重复的次数
        for (int i = 0; i < s.length(); i++) {
            // 当前的char字符
            char c = s.charAt(i);
            if (c >= '0' && c <= '9'){
                // 如果是数字，计算重复次数
                num = num*10 + (c-'0');
            } else if (c == '['){
                // 遇到[，开始记录重复的字符，并把重复的次数保存到栈中
                stack.push(String.valueOf(num));
                // 提示符，表示是数字，而不是字符
                stack.push("--");
                num = 0;
            } else if (c == ']'){
                // 遇到]，开始出栈，逆向记录字符
                String temp = "";
                while (!stack.peek().equals("--")){
                    temp = stack.pop() + temp;
                }
                // 弹出“--”
                stack.pop();
                String string = "";
                // 弹出重复次数
                int times = Integer.valueOf(stack.pop());
                for (int j = 0; j < times; j++) {
                    string += temp;
                }
                // 将重复后的字符串保存到栈中
                stack.push(string);
            } else {
                // 将字符保存到栈中
                stack.push(c+"");
            }
        }
        // 逆向记录栈中所有的字符串
        String result = "";
        while (!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result;
    }
}