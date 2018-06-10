public class Solution {
    /**
     * @param bits: a array represented by several bits. 
     * @return: whether the last character must be a one-bit character or not
     */
    public boolean isOneBitCharacter(int[] bits) {
        // Write your code here
        // 判空（测试例子有问题，[1]应该也是返回false的，但是是true）
        if (bits == null || bits.length <= 1) return true;
        // 从0开始
        int i;
        for (i = 0; i < bits.length-1; ) {
            // 如果当前值为0，则向后移动一位，为1则移动2位
            if (bits[i] == 0) i ++;
            else i += 2;
        }
        // 判断最后的位置是否在数组末尾以及最后一位是否为0
        return i == bits.length-1 && bits[i] == 0;
    }
}