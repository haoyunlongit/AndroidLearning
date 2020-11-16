import java.base.AlgorithmBase;
import java.base.ListNode;

public class RemoveNthFromEnd extends AlgorithmBase {
    @Override
    public void doExecute() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode temp = removeNthFromEnd(node, 2);
        while (temp != null) {
            System.out.println(temp.val + "->");
            temp = temp.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
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
}
