public class Solution {
    /**
     * @param str: the str
     * @return: the sum of bytes in the last word
     */
    public int judgeTheLastNumber(String str) {
        // Write your code here
        int i;
        for (i = 0; i < str.length()-1; ) {
            char c = str.charAt(i);
            if (c == '1') i+= 2;
            else i+=1;
        }
        return i==str.length()?2:1;
    }
}