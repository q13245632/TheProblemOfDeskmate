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
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        // 一种方法是利用set，很简单
        // 这里快慢指针的算法
        // 判空
        if (head == null || head.next == null) return null;
        // 快慢指针
        ListNode slow = head, fast = head;
        // 如果存在环，fast比slow多走了一个环的长度
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        // 根据fast和其后继节点判断是否有环
        if (fast == null || fast.next == null) return null;
        // fast比slow多走了一个环的长度，所以slow没有扫描的环的长度与环起始节点前的链表长度是相等的
        // 两个公式计算：
        // fast表示快指针走过的长度，slow表示慢指针走过的长度，m表示环的长度
        // fast = 2*slow；fast=slow+m
        // slow = m；
        // 由于slow并没有完整的遍历一个环，所以
        // slow走过的长度m等于从head到环起始节点的长度k加上走过环的长度a；
        // slow = k + a = m
        // 所以, k = m - a;
        // 也就是说slow没有走过的环的节点的长度等于从head到环起始节点的长度，
        // 两个长度的交点就是环的起始节点
        ListNode pHead = head;
        while (pHead != slow){
            pHead = pHead.next;
            slow = slow.next;
        }
        return slow;
    }
}