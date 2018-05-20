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
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) return;
        // 利用栈保存节点的先后顺序
        Stack<ListNode> stack = new Stack<>();
        ListNode pHead = head;
        while (pHead != null){
            stack.push(pHead);
            pHead = pHead.next;
        }
        // 从头结点开始进行交替插入
        pHead = head;
        // 当前节点和后继均与栈最上的节点不同时，进行插入,主要根据链表的长度(奇偶)判断
        // 1->2->3->4-null
        // 栈中分别是4,3,2,1
        // 交替插入步骤为
        // 1->4->2->3->4->null， 此时栈中为3,2,1，插入后当前节点指向2，其后继节点3与栈顶节点相同，停止插入

        // 1->2->3-null
        // 栈中分别是3,2,1
        // 交替插入步骤为
        // 1->3->2->3->null， 此时栈中为2,1，插入后当前节点指向2，其与栈顶节点相同，停止插入
        while (pHead != stack.peek() && pHead.next != stack.peek()){
            ListNode node = stack.pop();
            node.next = pHead.next;
            pHead.next = node;
            pHead = pHead.next.next;
        }
        // 栈顶的节点为重新排序后的最后一个节点，所以将其后续设为null
        ListNode node = stack.pop();
        node.next = null;
    }
}