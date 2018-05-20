/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
    /*
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        // 判空
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        // 快慢指针寻找链表的中点，并使用last保存中点的前驱节点
        ListNode slow = head, fast = head, last = slow;
        while (fast.next != null && fast.next.next != null){
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow为链表的中间节点，即为树(子树)的根节点，
        // 右子树由中间节点的后续节点构成，左子树由中间节点的前驱节点构成
        fast = slow.next;
        last.next = null; // 将中间节点的前驱节点的后继设为null
        TreeNode root = new TreeNode(slow.val); // 构造根节点
        if (head != slow) root.left = sortedListToBST(head); // 递归构造左子树
        root.right = sortedListToBST(fast); // 递归构造右子树
        return root;
    }
}