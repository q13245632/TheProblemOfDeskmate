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
     * @param l1: The first list.
     * @param l2: The second list.
     * @return: the sum list of l1 and l2.
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // 因为链表顺序保存数字，利用栈后进先出的性质从数字的最后一位进行计算
        Stack<Integer> first = new Stack<>(), second = new Stack<>();
        ListNode one = l1, two = l2;
        // 将链表的数字保存到栈中
        while (one != null){
            first.push(one.val);
            one = one.next;
        }
        while (two != null){
            second.push(two.val);
            two = two.next;
        }
        int carry = 0; // 进位
        ListNode head = new ListNode(-1); // 辅助头结点
        while (!first.isEmpty() || !second.isEmpty()){
            int a = first.isEmpty() ? 0 : first.pop(); // 取值，当栈为空是，值为0
            int b = second.isEmpty() ? 0 : second.pop();
            int sum = a+b+carry; // 与进位一起进行计算
            carry = sum/10; // 计算进位
            ListNode temp = new ListNode(sum%10); // 当前计算的结果
            temp.next = head.next; // 将计算的结果连接到辅助头结点的后面
            head.next = temp;
        }
        if (carry != 0){
            // 进位不为0，将头结点的值设置成进位，返回头节点
            head.val = carry;
            return head;
        }
        // 没有进位，返回头结点的后继节点
        return head.next;
    }
}