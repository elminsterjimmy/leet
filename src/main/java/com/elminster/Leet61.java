package com.elminster;

public class Leet61 {

    public static ListNode rotateRight(ListNode head, int k) {
        if (null == head) {
            return null;
        }
        ListNode node = head;
        int i = 0;
        int len = 1;
        while (null != node.next) {
            node = node.next;
            len++;
        }
        node.next = head;
        ListNode tail = node;
        node = head;
        ListNode pre = node;

        int shift = k % len;
        while (node != tail) {
            node = node.next;
            i++;
            if (i > shift) {
                pre = pre.next;
            }
        }

        head = pre.next;
        pre.next = null;

        return head;
    }

    public static void main(String[] args) {
        //0->1->2->NULL, k = 4
        ListNode head = new ListNode(0).append(new ListNode(1).append(new ListNode(2)));
        print(rotateRight(head, 2));
    }

    static void print(ListNode node) {
        if (null != node) {
            System.out.print(node.val + "->");
            print(node.next);
        } else {
            System.out.println("NULL");
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode append(ListNode node) {
            if (null != this.next) {
                next.append(node);
            } else {
                this.next = node;
            }
            return this;
        }
    }
}
