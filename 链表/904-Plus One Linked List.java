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
     * @param head: the first Node
     * @return: the answer after plus one
     */
    public ListNode plusOne(ListNode head) {
        // Write your code here
        // 判空
        if (head == null) return new ListNode(1);
        // 从链表的最后一个节点开始相加，类似于 221 链表求和II，
        // 利用栈后进先出进行相加求和
        Stack<ListNode> stack = new Stack<>();
        ListNode pHead = head;
        while (pHead != null) {
            stack.push(pHead);
            pHead = pHead.next;
        }
        // 最后一个节点加1，判断是否有进位
        ListNode node = stack.pop();
        int sum = node.val + 1;
        // 进位
        int carry = sum/10;
        // 直接对原节点赋值（计算后的值）
        node.val=sum%10;
        // 循环判断是否有进位以及栈是否为空
        // 进行进位求和计算
        while (carry != 0 && !stack.isEmpty()){
            node = stack.pop();
            sum = node.val + carry;
            carry = sum/10;
            node.val = sum%10;
        }
        // 最后仍然有进位，构建新的节点表示进位，并加在原链表头结点的前面
        if (carry != 0){
            ListNode result = new ListNode(carry);
            result.next = head;
            return result;
        }
        // 没有进位，返回原节点
        return head;
    }
}