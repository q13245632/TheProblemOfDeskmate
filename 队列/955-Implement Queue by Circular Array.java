public class CircularQueue {
    int[] array; // 保存元素
    int last = 0; // 队列尾部的位置
    int start = 0; // 队列开始的位置
    int count = 0; // 队列中的元素个数
    public CircularQueue(int n) {
        // initialize your data structure here
        // 初始化
        this.array = new int[n];
    }
    /**
     * @return:  return true if the array is full
     */
    public boolean isFull() {
        // write your code here
        // 判断count是否与数组长度相等
        return count == this.array.length;
    }

    /**
     * @return: return true if there is no element in the array
     */
    public boolean isEmpty() {
        // write your code here
        return count == 0;
    }

    /**
     * @param element: the element given to be added
     * @return: nothing
     */
    public void enqueue(int element) {
        // write your code here
        // 在队列尾部插入元素
        // 修改队尾位置以及计数
        this.array[last%array.length] = element;
        last ++;
        count ++;
    }

    /**
     * @return: pop an element from the queue
     */
    public int dequeue() {
        // write your code here
        // 修改队首的位置及计数
        int result = this.array[start%array.length];
        start ++;
        count --;
        return result;
    }
}