/**
 * Definition for singly-linked list.
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
    /*
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    // 两种方法，第一种好理解，第二种稍微复杂
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        // write your code here
        // 判空
        if (headA == null || headB == null) return null;
        // 最简单的是使用Set，进行判断是否有重复元素，利用Map的key也可以
        Set<ListNode> set = new HashSet<>();
        // 循环将headA链表中的节点加入集合中
        ListNode pHead = headA;
        while (pHead != null){
            set.add(pHead);
            pHead = pHead.next;
        }
        // 逐一判断集合中是否已有相同的元素，找到第一个相同的就是两个链表的交叉点，返回该节点
        pHead = headB;
        while (pHead != null){
            if (set.contains(pHead)) return pHead;
            pHead = pHead.next;
        }
        return null;
    }
    
    
    /*
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        // 判空
        if (headA == null || headB == null) return null;
        // 第二种方法，比较费脑子
        ListNode pHeadA = headA, pHeadB = headB;
        // 总的思路是两个指针交替遍历headA和headB节点，
        // 在第二趟遍历中要么同时为null，要么在第一个交叉点相遇
        // 画个示意图就明白了
        while (pHeadA != pHeadB){
            pHeadA = pHeadA.next != null ? pHeadA.next : headB;
            pHeadB = pHeadB.next != null ? pHeadB.next : headA;
        }
        return pHeadA;
    }
    
    
}