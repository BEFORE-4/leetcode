package chap1;

/**
 * 删除链表的倒数第N个节点
 */
public class Solution19 {

    public  static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0); //设置一个预先节点
        start.next = head;   //该节点的下个节点为链表头部
        ListNode p = start, q = start;   //设置两个哨兵节点
        //哨兵p节点向前移动n次，使之与哨兵q相差n个节点
        while (n != 0){
            p = p.next;
            n --;
        }
        //两个节点同时向后移动，直至p到达尾部节点。此时q节点为倒数第(n+1)个节点
        while (p.next != null){
            p = p.next;
            q = q.next;
        }
        //删除倒数第n个节点
        q.next = q.next.next;
        //返回头部节点。用start.next是为了规避只有一个节点时，头部节点被删除
        return start.next;
    }
}

/**
 * 节点类
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}