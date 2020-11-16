package java.linkList;

import java.base.AlgorithmBase;
import java.base.ListNode;

public class mergeLists extends AlgorithmBase {
    @Override
    protected void doExecute() {

    }

    /**
     * 创建一个新的链表
     * 时间复杂度O(n) 空间 O(n)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeLists1(ListNode list1, ListNode list2) {
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

    /**
     * 这种思路是在原有数组上进行操作，相对于上面的算法复杂一些
     * 时间复杂度O(n) 空间 O(n)
     * ！注意。 要比较p1.next,这样就不必考虑 pre指针
     * @param list1
     * @param list2
     * @return
     */
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
