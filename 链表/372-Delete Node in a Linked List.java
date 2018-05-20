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
 */


public class Solution {
    /*
     * @param node: the node in the list should be deletedt
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        // 参数node为需要删除的节点
        // 判空
        if (node == null) return;
        // 根据node的后继节点进行判断
        ListNode next = node.next;
        if (next == null) {
            node = null;
            return;
        }
        // 将node的值更改为其后继节点的值，并将
        // 其后继指向后继节点的后继节点
        node.val = next.val;
        node.next = next.next;
    }
}