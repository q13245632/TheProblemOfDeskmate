public class Solution {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here
        // 判空
        if (digits == null || digits.length <= 0) return new int[0];
        // 计算最后一位加1的结果，并计算进位
        int sum = digits[digits.length-1]+1;
        int carry = sum/10;
        // 保存结果
        digits[digits.length-1] = sum%10;
        // 依次从低位到高位对进位进行计算
        for (int i = digits.length-2; i>=0 ; i--) {
            sum = carry + digits[i];
            digits[i] = sum%10;
            carry = sum/10;
        }
        // 如果最后仍有进位，则重建数组，将进位赋值在0的位置
        if (carry == 1){
            int[] result = new int[digits.length+1];
            result[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                result[i+1] = digits[i];
            }
            return result;
        }
        // 没有进位，直接返回
        return digits;
    }
}