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
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null || head.next == null) return head;
        // 辅助头结点
        ListNode pHead = new ListNode(-1);
        // 辅助头节点指向head
        pHead.next = head;
        // 保存当前节点
        ListNode curr = head;
        // 判断相邻的两个节点是否均为空，都不为空时才能进行值的判断
        while (curr != null && curr.next != null){
            // 判断两个节点的值是否相等
            if (curr.val == curr.next.val){
                // 相等则删除后面的节点
                curr.next = curr.next.next;
            } else {
                // 不相等则向后移动当前节点
                curr = curr.next;
            }
        }
        return pHead.next;
    }
}