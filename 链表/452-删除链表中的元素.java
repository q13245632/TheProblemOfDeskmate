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
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        if (head == null) return head;
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode curr = pHead;
        while (curr.next != null){
            if (curr.next.val == val){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return pHead.next;
    }
}