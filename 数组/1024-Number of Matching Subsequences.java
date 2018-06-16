public class Solution {
    /**
     * @param S: a string
     * @param words: a dictionary of words
     * @return: the number of words[i] that is a subsequence of S
     */
    public int numMatchingSubseq(String S, String[] words) {
        // Write your code here
        // 判空
        if (words == null || S == null || words.length <= 0 || S.length() <= 0) return 0;
        // 计数
        int count = 0;
        // 遍历
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int curr = 0, pos = 0;
            // 判断当前单词是否为S的子序列
            while (curr < word.length() && pos < S.length()){
                if (word.charAt(curr) == S.charAt(pos)){
                    curr ++;
                }
                pos ++;
            }
            // 当curr等于word.length()时，则为子序列
            if (curr == word.length()) count ++;
        }
        return count;
    }
}