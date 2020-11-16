package java.linkList;

import java.base.ListNode;
import java.util.List;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode per = null;
        ListNode target = head;
        while (target != null) {
            ListNode temp = target.next;
            target.next = per;
            per = target;
            target = temp;
        }
        return per;
    }

    public static void main(String[] args) {

    }
}
