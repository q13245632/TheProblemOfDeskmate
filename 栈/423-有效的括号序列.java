public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        // 判空
        if (s == null || s.length() <= 0) return true;
        // 利用栈进行括号的判定
        Stack<Character> stack = new Stack<>();
        // 字符数组
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char curr = array[i];
            if (curr == '(' || curr == '[' || curr == '{'){
                // 左括号全部保存到栈中
                stack.push(curr);
            } else if (!stack.isEmpty() && curr == ')' && stack.peek() == '('){
                // 栈顶字符与当前的括号匹配时弹出，注意栈不能为空
                stack.pop();
            } else if (!stack.isEmpty() && curr == ']' && stack.peek() == '['){
                // 栈顶字符与当前的括号匹配时弹出，注意栈不能为空
                stack.pop();
            } else if (!stack.isEmpty() && curr == '}' && stack.peek() == '{'){
                // 栈顶字符与当前的括号匹配时弹出，注意栈不能为空
                stack.pop();
            } else {
                // 全部不匹配。返回false；
                return false;
            }
        }
        // 最后，如果栈为空，说明全部匹配，不为空，则说明部分括号没有匹配项，返回false
        return stack.isEmpty();
    }
}