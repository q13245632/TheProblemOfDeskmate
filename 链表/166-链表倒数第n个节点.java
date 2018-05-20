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
     * @return: Nth to last node of a singly linked list. 
     */
    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null) return head;
        int len = 0;
        ListNode pHead = head;
        while (pHead != null){
            len ++;
            pHead = pHead.next;
        }
        if (len < n) return null;
        pHead = head;
        for (int i = 0; i < len-n; i++) {
            pHead = pHead.next;
        }
        return pHead;
    }
}