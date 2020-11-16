package java.linkList;

import java.base.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateRight {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        rotateRight1(listNode, 2);
    }

    static public ListNode rotateRight1(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        int length = 1;
        while (p.next != null) {
            p = p.next;
            length ++;
        }

        int sublength = length - k % length;
        p.next = head;
        for (int i = 0; i < sublength; i++) {
            p = p.next;
        }
        ListNode temp = p.next;
        p.next = null;
        return temp;
    }

    static public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = listLength(head);
        int off = k % length;
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp;
        for (int i = 0; i < off; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        temp = slow.next;
        slow.next = null;
        return temp;
    }

    static int listLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length ++;
        }

        return length;
    }
}
