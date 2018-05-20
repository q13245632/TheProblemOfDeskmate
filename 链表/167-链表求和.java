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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        // 判空
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // 辅助链表头结点
        ListNode pHead = new ListNode(-1);
        // 变量保存三个链表的当前节点
        ListNode first = l1, second = l2, curr = pHead;
        int carry = 0; // 进位
        while (first != null && second != null){
            // 计算当前节点的和，同时与进位相加
            int sum = first.val + second.val + carry;
            carry = sum/10; // 计算进位
            curr.next = new ListNode(sum%10); // 计算当前和的值
            // 三个链表的节点同时向后移动
            curr = curr.next;
            first = first.next;
            second = second.next;
        }
        // 若第一个链表没有计算完，则继续计算
        while (first != null){
            int sum = first.val + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            first = first.next;
        }
        // 若第二个链表没有计算完，则继续计算
        while (second != null){
            int sum = second.val + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            second = second.next;
        }
        // 判断最后是否还有进位，如果有，保存到链表的最后位置
        if (carry != 0){
            curr.next = new ListNode(carry);
        }
        return pHead.next;
    }
}