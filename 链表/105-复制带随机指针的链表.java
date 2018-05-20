/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        // write your code here
        // 判空
        if (head == null) return head;
        // 复制节点，并放在原节点的后面
        // 假设开始是1->2->3->4，复制节点后：1->1`->2->2`->3->3`->4->4`
        RandomListNode pHead = head;
        while (pHead != null){
            RandomListNode next = new RandomListNode(pHead.label);
            next.next = pHead.next;
            pHead.next = next;
            pHead = next.next;
        }
        // 复制随机指针
        // 将原节点的random指针复制到copy节点的random指针上
        pHead = head;
        while (pHead != null){
            if (pHead.random != null) pHead.next.random = pHead.random.next;
            pHead = pHead.next.next;
        }
        // 分割链表
        // 原节点与copy节点进行拆分
        pHead = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return pHead;
    }
}