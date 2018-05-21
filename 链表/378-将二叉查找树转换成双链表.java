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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    // 辅助头结点
    DoublyListNode result = new DoublyListNode(-1);
    // 当前访问树节点的前驱节点
    DoublyListNode pre = result;
    // 当前访问的树节点
    DoublyListNode curr = null;
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        inOrder(root);
        return result.next;
    }

    // 树的中序遍历
    private void inOrder(TreeNode root){
        // 判空，一定要有，要不然程序无法终止
        if (root == null) return;
        inOrder(root.left);
        // 访问的树的当前节点
        curr = new DoublyListNode(root.val);
        // 构建双链表
        pre.next = curr;
        curr.prev = pre;
        pre = pre.next;

        inOrder(root.right);
    }
}