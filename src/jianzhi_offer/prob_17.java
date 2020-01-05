package jianzhi_offer;

/**
 * @Description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Author: zf
 * @Date: 2020/1/5 10:49
 */
public class prob_17 {
    public static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        // 1. 特殊判定
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        // 2. 创建一个头节点
        ListNode merge = new ListNode(0);
        ListNode head = merge;
        // 3. 依次往下遍历
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                merge.next = new ListNode(list1.val);
                list1 = list1.next;
            }else {
                merge.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            merge = merge.next;
        }
        if (list1 == null) {
            merge.next = list2;
        }
        if (list2 == null) {
            merge.next = list1;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(9);
        ListNode list1 = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode ll1 = new ListNode(2);
        ListNode ll2 = new ListNode(4);
        ListNode ll3 = new ListNode(6);
        ListNode ll4 = new ListNode(7);
        ListNode ll5 = new ListNode(10);
        ListNode list2 = ll1;
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = ll4;
        ll4.next = ll5;
        prob_17 solution = new prob_17();
        solution.Merge(list1, list2);
    }
}
