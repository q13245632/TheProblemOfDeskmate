public class MinStack {
    // 初始化，利用min记录最小值
    Stack<Integer> stack = null;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        // do intialization if necessary
        // 初始化栈
        stack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        // 向栈中保存元素时，记录最小值
        if (min > number){
            min = number;
        }
        // 将当前值和最小值同时入栈，上面为最小值
        stack.push(number);
        stack.push(min);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        stack.pop(); // 弹出最小值
        int k = stack.pop(); // 弹出栈顶的值
        // 判空，重新记录最小值
        if (stack.isEmpty()) min = Integer.MAX_VALUE;
        else min = stack.peek();
        return k;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        // 返回最小值
        return min;
    }
}