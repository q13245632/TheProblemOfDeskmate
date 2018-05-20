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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        // 假设链表1->2->3->4->5->null向右移动2位，变为4->5->1->2->3->null
        // 只需要寻找原来链表倒数第k个节点以及k-1个节点，将倒数k-1节点的后继设为null，
        // 倒数第k个节点为移动后头结点，原来链表最后节点指向头结点即可
        if (head == null || head.next == null) return head;
        // 利用栈后进先出的性质进行操作
        Stack<ListNode> stack = new Stack<>();
        ListNode pHead = head;
        while (pHead != null){
            stack.push(pHead);
            pHead = pHead.next;
        }
        // 计算需要移动的节点个数
        int n = k%stack.size();
        // n为0时，不需要移动
        if (n == 0) return head;
        // 保存最后节点以及当前节点，利用栈寻找倒数第k个节点
        ListNode last = stack.peek(), curr = null;
        while (n>0){
            curr = stack.pop();
            n--;
        }
        // pre为原来倒数第k-1个节点，移动后为最后一个节点，所以后继节点为null
        ListNode pre = stack.pop();
        pre.next = null;
        // 原来最后一个节点的后继节点为原来链表的头结点
        last.next = head;
        return curr;
    }
}