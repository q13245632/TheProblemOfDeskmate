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
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        // 判空
        if (head == null) return head;
        // 辅助头结点
        ListNode pHead = new ListNode(-1);
        // 将head节点连接到辅助头结点后面
        pHead.next = head;
        // 利用节点p1找到第m个节点的前一个节点
        ListNode p1 = pHead;
        int k = 1;
        while (p1.next != null && k < m) {
            p1 = p1.next;
            k++;
        }
        // pre表示第m个节点的前一个节点，从第m到第n个开始翻转
        ListNode pre = p1;
        // curr表示第m个节点，next表示第m个节点
        ListNode curr = pre.next, last = null, next = curr;
        // 从第m到第n个开始翻转,翻转代码参考 35题翻转链表
        while (k <= n && curr != null){
            ListNode temp = curr.next;
            curr.next = last;
            last = curr;
            curr = temp;
            k ++;
        }
        // pre为原链表第m个节点的前一个节点，需要将翻转后的第m个节点连接到后面
        pre.next = last;
        // next表示第m个节点，翻转过后为第n个节点；需要将原链表第n个之后的节点连接到翻转后的第n个节点
        next.next = curr;
        return pHead.next;
    }
}