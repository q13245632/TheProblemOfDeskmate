/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        // 利用队列层次遍历
        // 保存结果
        List<List<Integer>> result = new ArrayList<>();
        // 保存每层的节点值
        List<Integer> list = new ArrayList<>();
        // 判空
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 添加根节点
        queue.add(root);
        // 记录当前访问的节点总数
        int start = 0;
        // 记录当前层的节点总数
        int count = queue.size();
        while (!queue.isEmpty()){
            // 依次弹出节点
            TreeNode node = queue.poll();
            // 当前访问的节点总数加1
            start ++;
            // 添加节点的值到列表
            list.add(node.val);
            // 添加当前节点的子节点
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            // 判断当前层的所有节点是否全部访问
            // 两者相等，当前访问的节点总数等于当前层的节点总数
            // 当前层已经全部访问完毕
            if (start == count){
                // 将当前层的list加入结果
                result.add(list);
                // 重新记录
                list = new ArrayList<>();
                // 当前访问的节点总数归0
                start = 0;
                // 记录当前层的节点总数
                count = queue.size();
            }
        }
        return result;
    }
}