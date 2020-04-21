package com.example.addtwonumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;
import java.util.Stack;
/*
  1:链表对当前节点操作，主要保存next 指针。约等于保留现场
  2：对于两链表长度不相同的情况处理
 */
public class MainActivity extends AppCompatActivity {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//
//        if (l2 == null) {
//            return l1;
//        }
//
//        ListNode n1 = l1, n2 = l2, header = null;
//        ListNode current = null;
//        int flag = 0;
//        while (n1 != null || n2 != null) {
//            ListNode cur1 = n1 == null ? new ListNode(0) : n1;
//            ListNode cur2 = n2 == null ? new ListNode(0) : n2;
//            int temp = cur1.val + cur2.val + flag;
//            flag = temp / 10;
//            ListNode tempNode = new ListNode(temp % 10);
//            if (header == null) {
//                header = tempNode;
//                current = tempNode;
//            } else {
//                current.next = tempNode;
//                current = current.next;
//            }
//            n1 = n1 == null ?  n1 : n1.next;
//            n2 = n2 == null ?  n2 : n2.next;
//        }
//
//        if (flag == 1) {
//            current.next = new ListNode(1);
//        }
//
//        return header;
//    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode header = l1;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int tempFlag = flag;
            flag = (l1.val + l2.val + tempFlag) / 10;
            l1.val = (l1.val + l2.val + tempFlag) % 10;

            if (l1.next != null && l2.next != null) {
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.next == null && l2.next != null) {
                l1.next = l2.next;
                l1 = l1.next;
                break;
            } else if (l1.next != null && l2.next == null){
                l1 = l1.next;
                break;
            } else {
                if (flag >= 1) {
                    l1.next =  new ListNode(1);
                    l1 = null;
                }
                break;
            }
        }

        while (l1 != null && flag >= 1) {
            int tempFlag = flag;
            flag =  (l1.val + tempFlag) / 10;
            l1.val = (l1.val + tempFlag) % 10;
            if (l1.next != null) {
                l1 = l1.next;
            } else if (flag >= 1) {
                l1.next = new ListNode(1);
                break;
            }
        }
        return header;
    }

}
