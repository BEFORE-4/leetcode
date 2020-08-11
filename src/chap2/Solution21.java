package chap2;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)  {
        ListNode pre = new ListNode(0); //设置一个哨兵节点
        ListNode now = pre; //每次需要更改的节点
        while (l2 != null && l1!=null){
            if (l1.val < l2.val){
                now.next = l1;  //l1的值小，将节点指向l1节点
                l1 = l1.next;   //将l1节点向后移动一个元素
            }else {
                now.next = l2;
                l2 = l2.next;
            }
            now = now.next;//指针节点始终为最后一个
        }
        if (l1 != null){
            now.next = l1;  //若只剩下l1有元素，则剩下的都指向l1
        }
        if (l2 != null)
            now.next = l2;  //若只剩下l2有元素，则剩下的都指向l2
        // now.next = l1 != null ? l1 : l2;
        // 上方的两个判断可以用三目运算符
        return pre.next;    //返回哨兵的下个节点即可
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
