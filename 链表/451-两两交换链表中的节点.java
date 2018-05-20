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
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // write your code here
        // write your code here
        if (head == null || head.next == null) return head;
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        // 1 -> 2 -> 3 -> 4
        // 两两交换主要三个点:1、第一个交换的节点first；2、第二个交换的节点second;
        // 3、两个节点的前驱节点；
        // 比如交换2和3，则需要记录 1,2,3三个节点引用
        // 以1 -> 2 -> 3 -> 4 交换 2,3为例， 此时curr为1，first为2，second为3
        ListNode curr = pHead, first = head, second = head.next;
        // 首先判断first和second是否都不为空，其中一个为空，则不能交换
        while (first != null && second != null){
            first.next = second.next; // 将第一个交换的节点first放在后面，first和second的next指针均指向4，即2和3的后继均为4
                                      //   1 -> 2 -> 4
                                      //        3 -> 4
            second.next = first;      // 将第二个需要交换的节点放在第一个前面，即3的next指针指向2
                                      //    1 -> 2 -> 4
                                      //    3 -> 2
            curr.next = second;       // 将两个交换节点的前驱节点curr指向交换后的第一个节点second
                                      //    1 -> 3 -> 2 -> 4 到此，2和3两两交换完成
            curr = first;             // 将curr，first，second指向下一对需要交换的两个节点
                                      // 同时判断是否为空
            first = curr.next;
            if (first != null) second = first.next;
            else second = null;
        }
        return pHead.next;
    }
}
