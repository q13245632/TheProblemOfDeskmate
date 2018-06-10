/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        // 判空
        if (list1 == null || list1.size() <= 0) return list2;
        if (list2 == null || list2.size() <= 0) return list1;
        // 保存结果
        List<Interval> result = new ArrayList<>();
        // 两个列表的指针
        int i = 0, j = 0;
        // last表示结果中的最后一个间隔，curr表示两个列表中需要合并的当前间隔
        Interval last = null, curr;
        while (i < list1.size() && j < list2.size()){
            // 根据间隔的start选择需要合并的间隔
            if (list1.get(i).start < list2.get(j).start){
                curr = list1.get(i);
                i++;
            } else {
                curr = list2.get(j);
                j++;
            }
            // 合并last和curr两个间隔
            last = merge(result,last,curr);
        }
        // 合并之前没有合并的list1部分
        while (i < list1.size()){
            last = merge(result,last,list1.get(i));
            i++;
        }
        // 合并之前没有合并的list2部分
        while (j < list2.size()){
            last = merge(result,last,list2.get(j));
            j++;
        }
        // 将最后的间隔保存到结果中
        if (last != null) result.add(last);
        return result;
    }

    private Interval merge(List<Interval> result, Interval last, Interval curr) {
        if (last == null){
            return curr;
        }
        // 根据当前间隔的start和last的end进行合并
        if (curr.start > last.end){
            result.add(last);
            return curr;
        }
        last.end = Math.max(last.end,curr.end);
        return last;
    }
}