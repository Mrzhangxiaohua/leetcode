package Prob_1_to_Prob_50;

/**
 * @Description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @Author: zf
 * @Date: 2019/7/1 21:05
 */


public class prob_19 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h1 = head;
        int len = 0;
        while (h1.next!=null){
            h1 = h1.next;
            len++;
        }
        if (len+1 == 1) {
            head = null;
            return head;
        }
        int index = len + 1 - n;
        ListNode h2 = head;
        if (index>0){
            for (int i = 0; i < index - 1; i++) {
                h2 = h2.next;
            }
        }else {
            return h2.next;
        }

        ListNode h3 = h2.next.next;
        h2.next = h3;

        return head;
    }

    public static void main(String[] args) {
        int[] data = {1,2};
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        for (int i = 0; i < data.length; i++) {
            head.next = new ListNode(data[i]);
            head = head.next;
        }
        int n = 2;
        removeNthFromEnd(listNode.next, n);
    }
}
