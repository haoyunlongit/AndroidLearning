package linkList;

import base.ListNode;

import java.util.List;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode pre = null;
        ListNode currentNode = head;
        ListNode nextNote = currentNode.next;
        head = nextNote;
        while (currentNode != null && nextNote != null) {
            ListNode temp = nextNote.next;
            nextNote.next = currentNode;
            if (pre != null) {
                pre.next = nextNote;
            }
            currentNode.next = temp;
            pre = currentNode;
            currentNode = temp;
            if (currentNode != null) {
                nextNote = currentNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);

    }
}
