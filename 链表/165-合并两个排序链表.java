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
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        // write your code here
        // 排序一般是双指针
        // 判空，基本都需要判空，包括数组，字符串等
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // 辅助头结点
        ListNode pHead = new ListNode(-1);
        // 使用变量保存需要移动的三个引用
        ListNode left = l1, right = l2, curr = pHead;
        // 由于需要对left和right的值进行比较，两者不能同时为空，
        // 当其中一个为空时，说明已经走到了链表的尾节点
        while (left != null && right != null){
            // 比较两个链表当前值的大小，只向后移动较小值的引用
            if (left.val<right.val){
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            // 移动辅助链表的引用
            curr = curr.next;
        }
        // 将后面不为空的链表连接到辅助链表后面
        // 1->2->3->4-null;
        // 2->3->4->5->6->null;
        if (left != null) curr.next=left;
        if (right != null) curr.next=right;
        return pHead.next;
    }
}