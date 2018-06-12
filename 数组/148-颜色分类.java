public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        // 判空
        if (nums == null || nums.length <= 1) return;
        // 双指针，记录红色的位置red，记录蓝色的位置blue
        int red = 0, blue = nums.length-1;
        // 扫描索引
        int start = 0;
        while (start <= blue){
            // 扫描到0的位置，
            // 与red的位置进行交换并更新指针
            if (nums[start] == 0){
                int temp = nums[red];
                nums[red] = 0;
                nums[start] = temp;
                red ++;
                start ++;
            } else if (nums[start] == 1){
                // 扫描到1，继续扫描
                start ++;
            } else {
                // 扫描到2的位置
                // 与blue的位置进行交换并更新指针
                int temp = nums[blue];
                nums[blue] = 2;
                nums[start] = temp;
                blue --;
            }
        }
    }
}