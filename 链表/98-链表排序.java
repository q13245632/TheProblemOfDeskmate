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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    // 寻找中间节点，快慢指针方法
    public ListNode getMiddle(ListNode head){
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // 两个有序链表合并，参考165-合并两个排序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode pHead = new ListNode(-1);
        ListNode left = l1, right = l2, curr = pHead;
        while (left != null && right != null){
            if (left.val<right.val){
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left != null) curr.next=left;
        if (right != null) curr.next=right;
        return pHead.next;
    }
    public ListNode sortList(ListNode head) {
        // write your code here
        // 判空
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddle(head);
        // 对中间节点后续的节点进行排序
        ListNode right = sortList(mid.next);
        // 将中间节点后续设为null，否则会对后面的节点排序，
        mid.next = null;
        // 对中间节点以前的节点进行排序，包括中间节点
        ListNode left = sortList(head);
        // 合并两个有序链表
        return merge(left, right);
    }
}