/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Reverselist {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        ListNode temp=null;
        //cur负责和原来的一样往后推进，然后使用temp来作为交换的临时变量，在用pre来记录之前的点再将cur的next指向pre就可以实现链表的原地反转
        while(cur!=null){//当当前的不为空
            temp=cur.next;//用临时变量来保存原来的方向
            cur.next=pre;//在此处进行反转，将链表的方向反转
            pre=cur;//新的链，将当前的这个已经反转的链给这个新的链
            cur=temp;//将原来的方向赋回来
        }
        return pre;
    }
}
