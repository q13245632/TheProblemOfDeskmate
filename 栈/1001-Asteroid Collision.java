public class Solution {
    /**
     * @param asteroids: a list of integers
     * @return: return a list of integers
     */
    public int[] asteroidCollision(int[] asteroids) {
        // write your code here
        // 判空
        if (asteroids == null || asteroids.length <= 0) return new int[0];
        // 利用栈进行模拟
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            // 当前数值
            int curr = asteroids[i];
            if (stack.isEmpty()){
                // 栈为空时，直接入栈
                stack.push(curr);
            } else if (curr + stack.peek() == Math.abs(curr) + Math.abs(stack.peek())){
                // 当前数值与栈顶元素为同符号时，直接入栈
                stack.push(curr);
            } else if (curr > 0 && stack.peek() < 0){
                // 当前数值为正，栈顶元素为负时，直接入栈
                stack.push(curr);
            } else {
                // 当前数值为负，栈顶元素为正时，判断哪个消失
                int last = curr;
                // 标识当前元素是否消失
                boolean flag = true;
                while (!stack.isEmpty() && last < 0 && stack.peek() > 0){
                    // 栈顶的元素绝对值大于当前数值，当前数值消失
                    if (Math.abs(stack.peek()) > Math.abs(last)){
                        flag = false;
                        break;
                    } else if (Math.abs(stack.peek()) < Math.abs(last)){
                        // 栈顶的元素绝对值小于当前数值，栈顶元素消失
                        stack.pop();
                    } else {
                        // 栈顶的元素绝对值等于当前数值，栈顶元素和当前数值均消失
                        flag = false;
                        stack.pop();
                        break;
                    }
                }
                // 如果当前元素没有消失，则入栈
                if (flag) stack.push(last);
            }
        }
        // 将栈中元素保存到数组中
        int[] result = new int[stack.size()];
        int pos = stack.size()-1;
        while (!stack.isEmpty()){
            result[pos--] = stack.pop();
        }
        return result;
    }
}