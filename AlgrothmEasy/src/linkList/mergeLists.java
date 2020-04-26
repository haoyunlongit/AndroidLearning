package linkList;

import base.AlgorithmBase;

public class mergeLists extends AlgorithmBase {
    @Override
    protected void doExecute() {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode p1,p2;
        if(list1.val < list2.val) {
            p1 = list1;
            p2 = list2;
        } else {
            p1 = list2;
            p2 = list1;
        }
        ListNode reuslt = p1;
        ListNode next1, next2;
        while (p1.next != null && p2 != null) {
            if(p1.next.val > p2.val) {
                next1 = p1.next;
                next2 = p2.next;
                p1.next = p2;
                p2.next = next1;
                p2 = next2;
            } else {
               p1 = p1.next;
            }
        }

        if (p1.next == null) {
            p1.next = p2;
        }

        return reuslt;
    }
}
