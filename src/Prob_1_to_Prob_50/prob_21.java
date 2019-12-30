package Prob_1_to_Prob_50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @Description: 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Author: zf
 * @Date: 2019/7/14 22:05
 */
public class prob_21 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
//        l1 = l1.next;
//        l2 = l2.next;
        while (l1!=null){
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            list.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(list);
        ListNode listNode = new ListNode(0);
        ListNode listNode_head = listNode;
        ListNode listNode_head1 = listNode;
        for (int i = 0; i < list.size(); i++) {
            ListNode listNode1 = new ListNode(list.get(i));
            listNode_head.next = listNode1;
            listNode_head = listNode_head.next;
        }
        return listNode_head1.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(0);
        ListNode l = listNode;
        ListNode l1 = listNode1;
        int[] x = {};
        int[] x1 = {};
        for (int i = 0; i < x.length; i++) {
            ListNode temp = new ListNode(x[i]);
            l.next = temp;
            l = l.next;
        }
        for (int i = 0; i < x1.length; i++) {
            ListNode temp = new ListNode(x1[i]);
            l1.next = temp;
            l1 = l1.next;
        }
        mergeTwoLists(listNode.next, listNode1.next);
    }
}
