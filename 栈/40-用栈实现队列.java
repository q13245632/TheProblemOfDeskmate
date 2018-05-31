public class MyQueue {
     /** Initialize your data structure here. */
     // 利用两个栈模拟队列操作
    Stack<Integer> stack1,stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 栈1负责记录数据
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 栈2负责临时保存数据，找到栈1底部的值
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int x = stack2.pop();
        // 将栈2的数按原顺序重新保存到栈1
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return x;
    }

    /** Get the front element. */
    public int top() {
        // top操作和pop操作类似，只是不用删除栈顶元素
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int x = stack2.peek();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return x;
    }
}