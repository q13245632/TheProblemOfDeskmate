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
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) return head;
        ListNode pHead = new ListNode(-1);
        ListNode curr = head, pre = pHead;
        while (curr != null){
            while (pre.next != null && pre.next.val < curr.val){
                pre = pre.next;
            }
            ListNode temp = pre.next;
            pre.next = curr;
            pre = pre.next;
            curr = curr.next;
            pre.next = temp;
            pre = pHead;
        }
        return pHead.next;
    }
}