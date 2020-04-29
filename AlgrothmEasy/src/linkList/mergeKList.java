package linkList;

import base.AlgorithmBase;
import base.ListNode;

/**
 * 合并k个链表
 */
public class mergeKList extends AlgorithmBase {
    @Override
    protected void doExecute() {

    }


    /**
     * 时间复杂度 n^2
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode header = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode tempList = lists[i];
            header = mergeList(header, tempList);
        }
        return header;
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode header = null, p;
        if (list1.val <= list2.val) {
            p = header = list1;
            list1 = list1.next;
        } else {
            p = header = list2;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if (list1 == null) {
            p.next = list2;
        }

        if (list2 == null) {
            p.next = list1;
        }
        return header;
    }
}
