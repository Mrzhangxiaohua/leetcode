package jianzhi_offer;

/**
 * @Description: 输入两个链表，找出它们的第一个公共结点。
 * @Author: zf
 * @Date: 2020/1/12 16:47
 */
public class prob_37 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode list1 = pHead1;
        ListNode list2 = pHead2;
        while (list1 != list2) {
            list1 = (list1 == null) ? pHead2 : list1.next;
            list2 = (list2 == null) ? pHead1 : list2.next;
        }
        return list1;
    }
}
