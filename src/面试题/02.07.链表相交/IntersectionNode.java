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
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int m=0,n=0;
        while(nodeA!=null){//计算A长度
            m++;
            nodeA=nodeA.next;
        }
        while(nodeB!=null){//计算B长度
            n++;
            nodeB=nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        if(n>m){//让nodeA为最长链表的头，m为其长度
            int temp = m;
            m=n;
            n=temp;

            ListNode tempNode=nodeA;
            nodeA=nodeB;
            nodeB=tempNode;
        }
        //长度差
        int x = m-n;
        //遍历两个链表遇到相同就返回
        while(x-->0){
            if(nodeA==nodeB){
                return nodeA;
            }
            nodeA=nodeA.next;
            nodeB=nodeB.next;
        }
        return null;
    }
}
