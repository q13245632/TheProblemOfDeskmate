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
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        if (head == null) return head;
        int len = 0;
        ListNode curr = pHead;
        while (curr.next != null){
            len ++;
            curr = curr.next;
        }
        curr = pHead;
        for (int i = 0; i < len - n; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return pHead.next;
    }
}