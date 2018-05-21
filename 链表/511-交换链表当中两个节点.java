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
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        // 判空
        if (head == null || head.next == null) return head;
        // 辅助头结点
        ListNode pHead = new ListNode(-1);
        // 将原链表接到pHead后面
        pHead.next = head;
        // 利用temp寻找值为v1和v2的节点的前驱节点
        ListNode temp = pHead;
        // prev1和prev2分别保存值为v1和v2的节点的前驱节点
        ListNode prev1 = null, prev2 = null;
        // 遍历寻找值为v1和v2的节点的前驱节点
        while (temp.next != null){
            if (temp.next.val == v1){
                prev1 = temp;
            } else if (temp.next.val == v2){
                prev2 = temp;
            }
            temp = temp.next;
        }
        // 判断是否存在值为v1和v2
        if (prev1 == null || prev2 == null) return head;
        // 保存值为v1和v2的节点以及他们的后继节点
        // node1和node2分别为值为v1和v2的节点
        ListNode node1 = prev1.next, node2 = prev2.next;
        // v1next和v2next分别为值为v1和v2的后继节点
        ListNode v1next = node1.next, v2next = node2.next;
        // 判断v1和v2是否是相邻节点
        if (prev1.next == prev2){
            // v1是v2节点的前驱节点
            // prev1->v1->v2->v2next
            prev1.next = node2;
            node2.next = node1;
            node1.next = v2next;
        } else if (prev2.next == prev1){
            // v2是v1节点的前驱节点
            // prev2->v2->v1->v1next
            prev2.next = node1;
            node1.next = node2;
            node2.next = v1next;
        } else {
            // 普通情况
            // prev1->v1->v1next->###->prev2->v2->v2next
            prev1.next = node2;
            node2.next = v1next;
            prev2.next = node1;
            node1.next = v2next;
        }
        return pHead.next;
    }
}