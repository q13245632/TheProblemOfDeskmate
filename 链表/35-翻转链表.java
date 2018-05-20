/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        // 判空
        if (head == null || head.next == null) return head;
        // 辅助头节点
        ListNode pHead = null;
        // 当前节点
        ListNode curr = head;
        // 判空
        while (curr != null){
            ListNode next = curr.next; // 保存当前节点的后继节点
            curr.next = pHead; // 当前节点的后继指向前一个节点
            pHead = curr; // 前一个节点向后移动
            curr = next; // 向后移动当前节点
        }
        return pHead;
    }
}