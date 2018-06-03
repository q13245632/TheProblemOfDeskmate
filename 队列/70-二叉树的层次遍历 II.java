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
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        // 和二叉树的层次遍历代码类似，
        // 只不过在保存结果的时候做些处理
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int start = 0;
        int count = queue.size();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            start ++;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (start == count){
                start = 0;
                count = queue.size();
                // 每次只把当前层的遍历结果保存到最前面
                result.add(0,list);
                list = new ArrayList<>();
            }
        }
        return result;
    }
}