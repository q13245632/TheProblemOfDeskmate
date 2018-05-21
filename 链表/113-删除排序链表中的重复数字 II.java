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
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        // 判空
        if (head == null || head.next == null) return head;
        // 辅助头结点
        ListNode pHead = new ListNode(-1);
        // 将原链表头结点连接到辅助头结点后面
        pHead.next = head;
        // 当前节点的位置
        ListNode curr = pHead;
        // 因为是排序链表，所以判断相邻的两个节点的值是否相同，
        // 如果相同，即为重复元素，不同则前一个节点不存在重复元素，后一个不确定
        // 例如 1->2->3->3->null    2->3相邻，2不存在重复元素，3存在
        while (curr.next != null && curr.next.next != null){
            // 判断相邻的两个节点值是否相同
            if (curr.next.val == curr.next.next.val){
                // 相同，删除所有为此值的节点
                int num = curr.next.val;
                while (curr.next != null && curr.next.val == num){
                    // curr.next节点值为num，则删除curr.next
                    curr.next = curr.next.next;
                }
            } else {
                // 相邻的两个节点值不相同，当前节点向后移动
                curr = curr.next;
            }
        }
        return pHead.next;
    }
}