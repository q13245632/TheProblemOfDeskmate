public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        // 回溯法
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (num == null || num.length <= 0) return result;
        // 使用标记
        boolean[] used = new boolean[num.length];
        Arrays.sort(num); // 排序
        // 回溯
        helper(result,list,num,used,target,0,0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] num, boolean[] used, int target, int sum, int start) {
        // 剪枝，否则会超时
        if (sum > target) return;
        // 结束条件
        if (sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        // 上次使用的数
        int last = -1;
        for (int i = start; i < num.length; i++) {
            if (last == num[i]) continue; // 跳过重复的数
            if (used[i]) continue; // 跳过已经使用过的数
            list.add(num[i]); // 添加到list
            last = num[i]; // 标记上次使用过的数
            used[i] = true; // 使用标记变为true
            // 回溯
            helper(result, list, num, used, target, sum+num[i], i+1);
            // 恢复变量，回溯回退
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}