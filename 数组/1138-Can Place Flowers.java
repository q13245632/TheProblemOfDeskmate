public class Solution {
    /**
     * @param flowerbed: an array
     * @param n: an Integer
     * @return: if n new flowers can be planted in it without violating the no-adjacent-flowers rule
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Write your code here
        int count = 0; // 记录可以放的总数
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue; // 如果当前已经有花，则跳过
            int left = i == 0 ? 0 : flowerbed[i-1]; // 查看当前花床左侧是否有花
            int right = i == flowerbed.length-1 ? 0 : flowerbed[i+1]; // 查看当前花床右侧是否有花
            if (left + right == 0){
                // 两个均没有花，则在当前位置种花
                flowerbed[i] = 1;
                count ++;
            }
        }
        return count >= n;
    }
}