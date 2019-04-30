package com.elminster;

public class Leet24 {

    public static ListNode swapPairs(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode pre = null;
        ListNode left = head;
        ListNode right = head.next;
        if (null == right) {
            return head;
        }

        while (null != right && null != left) {
            left.next = right.next;
            right.next = left;
            if (null != pre) {
                pre.next = right;
            } else {
                head = right;
            }
            pre = left;
            if (null != pre.next) {
                left = pre.next;
            } else {
                break;
            }
            if (null != left.next) {
                right = left.next;
            } else {
                break;
            }

            print(head);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1).append(new ListNode(2)).append(new ListNode(3)).append(new ListNode(4));
        print(swapPairs(head));
    }

    static void print(ListNode node) {
        if (null != node) {
            System.out.print(node.val + "->");
            print(node.next);
        } else {
            System.out.println();
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
