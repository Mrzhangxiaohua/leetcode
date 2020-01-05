package jianzhi_offer;

/**
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 * @Author: zf
 * @Date: 2020/1/5 10:03
 */
public class prob_15 {
    public static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0)
            return null;
        ListNode node1 = head, node2 = head;
        for (int i = 1; i < k; i++) {
            if (node1 == null)
                return null;
            node1 = node1.next;
        }
        if (node1 == null)
            return null;
        while (node1.next != null){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(9);
        ListNode head = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        prob_15 solution = new prob_15();
        solution.FindKthToTail(head, 2);
    }
}
