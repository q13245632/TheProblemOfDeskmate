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
     * @param head: A ListNode.
     * @return: A boolean.
     */
     public boolean isPalindrome(ListNode head) {
        // write your code here
        if (head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode pHead = head;
        while (pHead != null){
            stack.push(pHead.val);
            pHead = pHead.next;
        }
        pHead = head;
        while (pHead != null){
            if (pHead.val != stack.pop()) return false;
            pHead = pHead.next;
        }
        return true;
    }
}