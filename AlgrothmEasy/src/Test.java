import javax.print.DocFlavor;
import java.rmi.UnexpectedException;
import java.util.List;
import java.util.Stack;

public class Test {
    static void test() {
        System.out.println("~~~~~~~~~");
    }

   static  public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode p1 = head, p2 = head;
        ListNode pre = null;
        for (int i = 0; i < n; i++) {
            if (p1 == null) {
                // 越界 所求删除节点超出范围
                return null;
            }
            p1 = p1.next;
        }

        if (p1 == null) {
            return head.next;
        }

        while (p1 != null) {
            pre = p2;
            p2 = p2.next;
            p1 = p1.next;
        }

        pre.next = p2.next;

        return head;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        removeNthFromEnd(node, 2);
    }
}
