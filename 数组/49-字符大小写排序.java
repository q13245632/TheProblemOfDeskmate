public class Solution {
    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here
        if (chars == null || chars.length <= 0) return;
        int left = 0, right = chars.length-1;
        while (left < right){
            while (left < right && 'a' <= chars[left] && chars[left] <= 'z'){
                left ++;
            }
            while (left < right && 'A' <= chars[right] && chars[right] <= 'Z'){
                right --;
            }
            if (left < right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left ++;
                right --;
            }
        }
    }
}