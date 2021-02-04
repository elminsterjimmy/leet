package com.elminster;

public class Leet2 {

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode() {}
   * ListNode(int val) { this.val = val; }
   * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (null == l1) {
      if (null == l2) {
        return null;
      } else {
        return l2;
      }
    } else {
      if (null == l2) {
        return l1;
      } else {
        ListNode head = null;
        ListNode current = null;
        boolean oneUp = false;
        do {
          if (null == l1 && null == l2) {
            if (oneUp) {
              current.next = new ListNode(1);
            }
            break;
          }
          int count = ((null == l1 ? 0 : l1.val) + (null == l2 ? 0 : l2.val) + (oneUp ? 1 : 0));
          oneUp = (count >= 10);
          if (null == current) {
            current = new ListNode(count % 10);
            head = current;
          } else {
            current.next = new ListNode(count % 10);
            current = current.next;
          }
          l1 = null == l1 ? null : l1.next;
          l2 = null == l2 ? null : l2.next;
        } while (true);
        return head;
      }
    }
  }

  static public class ListNode {
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

  public static void main(String[] args) {
    ListNode head1 = new ListNode(2, new ListNode(4, new ListNode(9)));
    ListNode head2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
    ListNode ln = addTwoNumbers(head1, head2);
    while (null != ln) {
      System.out.print(ln.val);
      ln = ln.next;
    }
    System.out.println();
  }
}
