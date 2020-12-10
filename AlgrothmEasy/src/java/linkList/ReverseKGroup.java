package java.linkList;

import java.base.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode currentNode = head;
        ListNode preTail = null;
        ListNode groupHeader = null;
        ListNode resultHeader = null;
        while (currentNode != null) {
            boolean hashFinish = true;
            ListNode currentTail = null;
            for (int i = 0; i < k; i++) {
                if (currentNode == null) {
                    hashFinish = false;
                    break;
                }
                if (i == 0) {
                    currentTail = currentNode;
                }
                currentNode = currentNode.next;
            }

            if (hashFinish) {
                groupHeader = reverse(preTail);
                if (preTail != null) {
                    preTail.next = groupHeader;
                } else {
                    resultHeader = groupHeader;
                }
                preTail = currentTail;
            } else {
                if (preTail != null) {
                    preTail.next = currentTail;
                }
            }
        }

        return resultHeader;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}
