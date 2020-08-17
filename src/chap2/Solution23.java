package chap2;

/**
 * 分治法
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        //如果为空，直接返回null
        if (lists == null || lists.length == 0)
            return null;
        return recursion(lists, 0, lists.length - 1);
    }

    /**
     * 递归二分合并
     * @param lists
     * @param left
     * @param right
     * @return
     */
    public ListNode recursion(ListNode[] lists, int left, int right){
        if (left == right) //两者相等，就是同一个节点，直接返回
            return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = recursion(lists, left, mid); //二分合并左边的
        ListNode l2 = recursion(lists, mid + 1, right); //二分合并右边的
        return Merge2List(l1, l2);
    }

    /**
     * 合并两个链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode Merge2List(ListNode l1, ListNode l2){
        if (l1 == null) //l1为空，则返回l2
            return l2;
        if (l2 == null) //l2为空，则返回l1
            return l1;
        if (l1.val < l2.val){
            //如果l1的值小，那么就返回l1，并且将l1后边的递归合并
            l1.next = Merge2List(l1.next, l2);
            return l1;
        }else {
            //如果l2的值小，那么就返回l2，并且将l2后边的递归合并
            l2.next = Merge2List(l1, l2.next);
            return l2;
        }
    }
}
