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
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        // write your code here
        // 判空操作
        if (head == null || head.next == null) return head;

        // 使用两个链表分别保存小于x和大于等于x的节点
        // pHead为小于x的链表头结点；thead为大于等于x的链表头结点
        ListNode pHead = new ListNode(-1), tHead = new ListNode(-1);
        // 分别使用三个变量指向三个链表，进行操作, curr为原链表当前的节点
        ListNode pCurr = pHead, tCurr = tHead, curr = head;
        // 判断当前节点的是否为空
        while (curr != null){
            // 判断当前节点的值是否小于x
            if (curr.val < x){
                // 小于x，链接到小于x的链表的后面；并移动指针pCurr
                pCurr.next = curr;
                pCurr = curr;
            } else {
                // 大于等于x，链接到大于等于x的链表的后面；并移动指针tCurr
                tCurr.next = curr;
                tCurr = curr;
            }
            // 移动当前判断的节点
            curr = curr.next;
        }
        // 由于小于x的节点在前，大于等于x的节点在后，所以，将大于等于x的链表最后指向null；
        tCurr.next = null;
        // 小于x的链表最后一个节点指向大于等于x的链表的第一个节点
        pCurr.next = tHead.next;
        return pHead.next;
    }
}