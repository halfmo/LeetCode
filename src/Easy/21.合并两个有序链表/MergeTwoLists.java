/**
 * @author half_m
 * @version 1.0
 * @Package PACKAGE_NAME
 * @Classname MergeTwoLists
 * @Description TODO
 * @date 2022/4/10 8:13
 */

public class MergeTwoLists {
  class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  /**
   * 要合并两个链表，并且是升序
   * 递归写法
   *
   * @param list1 链表1
   * @param list2 链表2
   * @return ListNode 节点
   */
  public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    } else if (list2 == null) {
      return list1;
    } else if (list1.val < list2.val) {
      list1.next = mergeTwoLists1(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoLists1(list1, list2.next);
      return list2;
    }
  }

  /**
   * 合并两个有序链表
   * 迭代写法
   *
   * @param list1 链表1
   * @param list2 链表2
   * @return 返回链表节点
   */
  public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
    ListNode prehead = new ListNode(-1);
    ListNode pre = prehead;
    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        pre.next = list1;
        list1 = list1.next;
      }else {
        pre.next = list2;
        list2 = list2.next;
      }
      pre = pre.next;
    }
    pre.next = list1 == null ? list2 : list1;
    return prehead.next;
  }

}
