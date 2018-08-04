public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (n<=0) return result;
        List<Integer> list = new ArrayList<>();
        helper(result, list, n);
        return result;
    }

    private void helper(List<List<String>> result, List<Integer> list, int n) {
        if (list.size() == n){
            result.add(buildBoard(new ArrayList<>(list)));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(list, i)){
                continue;
            }
            list.add(i);
            helper(result, list, n);
            list.remove(list.size()-1);
        }
    }

    private List<String> buildBoard(List<Integer> list){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                stringBuilder.append(j == list.get(i) ? 'Q' : '.');
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    private boolean isValid(List<Integer> list, int i) {
        int row = list.size();
        for (int j = 0; j < row; j++) {
            if (i == list.get(j)) return false;
            if (j+list.get(j) == row+i) return false;
            if (j-list.get(j) == row-i) return false;
        }
        return true;
    }
}