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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        // 利用set的性质，比较简单
        // 另一种是快慢指针，有时间再写，
        Set<ListNode> set = new HashSet<>();
        if (head == null || head.next == null) return false;
        ListNode pHead = head;
        while (pHead != null){
            if (!set.add(pHead)) return true;
            pHead = pHead.next;
        }
        return false;
    }
}