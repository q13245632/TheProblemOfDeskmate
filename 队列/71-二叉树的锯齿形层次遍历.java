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
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        // 二叉树的层次遍历
        // 使用一个level表示当前遍历的层数，从0开始
        // 如果是奇数层，则翻转当前的list
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int start = 0;
        int count = queue.size();
        // 记录当前遍历的层数，
        // 如果是奇数层，则翻转list，表示从右往左
        int level = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            start ++;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (start == count){
                start = 0;
                count = queue.size();
                if (level % 2 == 1) Collections.reverse(list);
                result.add(list);
                list = new ArrayList<>();
                level ++;
            }
        }
        return result;
    }
}