public class Solution {
    /**
     * @param rowIndex: a non-negative index
     * @return: the kth index row of the Pascal's triangle
     */
    public List<Integer> getRow(int rowIndex) {
        // write your code here
        List<Integer> list = new ArrayList<>(); // 记录当前行的杨辉三角值
        if (rowIndex <= 0) return list; // 判空
        List<Integer> pre = new ArrayList<>(); // 记录上一行的杨辉三角值
        pre.add(1);
        pre.add(1); // 第一行为[1,1]
        for (int i = 1; i < rowIndex; i++) {
            // 根据上一行计算当前行的杨辉三角值
            for (int j = 1; j < pre.size(); j++) {
                list.add(pre.get(j)+pre.get(j-1));
            }
            // 在首尾添加1
            list.add(0,1);
            list.add(1);
            pre = list;
            list = new ArrayList<>();
        }
        return pre;
    }
}