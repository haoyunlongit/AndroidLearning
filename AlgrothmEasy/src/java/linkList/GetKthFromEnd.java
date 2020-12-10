package java.linkList;

import java.base.ListNode;
import java.util.List;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (k > 1) {
            fast = fast.next;
            k--;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
