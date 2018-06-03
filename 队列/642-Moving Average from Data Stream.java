public class MovingAverage {
    /*
     * @param size: An integer
     */
    Queue<Integer> queue = null;
    long sum = 0; // 使用int会溢出
    int size = 0;
    public MovingAverage(int size) {
        // do intialization if necessary
        queue = new LinkedList<>();
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        // write your code here
        if (queue.size() < this.size){
            queue.add(val);
            sum += val;
        } else if (queue.size() == this.size){
            int first = queue.poll();
            sum -= first;
            queue.add(val);
            sum += val;
        }
        return sum * 1.0 / queue.size();
    }
}