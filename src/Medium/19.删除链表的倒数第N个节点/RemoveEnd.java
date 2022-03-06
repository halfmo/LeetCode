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
public class RemoveEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hx=new ListNode(-1);
        hx.next=head;
        ListNode fast=hx;
        ListNode slow=hx;
        ListNode temp=null;
        while (n-- > 0) {
            fast = fast.next;
        }
        while(fast!=null){
            temp=slow;
            slow=slow.next;
            fast=fast.next;
        }
        temp.next=slow.next;
        // temp.next=slow.next;
        slow.next=null;
        //当fast为空要删除slow
        return hx.next;
    }
}
