public class Solution {
    /*
     * @param : a continuous stream of numbers
     * @param : a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        // 判空
        if (nums == null || nums.length <= 0) return -1;
        // 记录出现的数字和次数
        Map<Integer,Integer> map = new HashMap<>();
        // 使用队列保存出现的有序数字
        Queue<Integer> queue = new LinkedList<>();
        // 判断原数组中是否有number，没有则直接返回-1
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            // 遍历到number时，则退出循环
            if (nums[i] == number) {
                flag = true;
                // 将number保存到map和队列中
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                queue.add(nums[i]);
                break;
            }
            // 保存出现的数字的次数
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            // 按照出现的顺序进入队列
            queue.add(nums[i]);
        }
        if (!flag) return -1; // 原数组中没有number，则直接返回-1
        // 依次查找队列中的数字出现的次数
        // 如果为1，则直接返回
        while (!queue.isEmpty()){
            int curr = queue.poll();
            if (map.get(curr) == 1) return curr;
        }
        return -1;
    }
};