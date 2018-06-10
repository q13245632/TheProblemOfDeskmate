public class Solution {
    /**
     * @param head: the given linked list
     * @return: the array that store the values in reverse order 
     */
    public List<Integer> reverseStore(ListNode head) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        // 判空
        if (head == null) return list;
        // 辅助变量
        ListNode pHead = head;
        // 判断当前节点是否为空
        while (pHead != null){
            // 将当前节点的插入索引0的位置，原来的数据自动向后移动
            // 例如原来的list为[1],在索引0插入0后，list变为[0,1]
            list.add(0,pHead.val);
            // 向后移动当前节点
            pHead = pHead.next;
        }
        return list;
    }
}