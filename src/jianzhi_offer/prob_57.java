package jianzhi_offer;

/**
 * @Description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Author: zf
 * @Date: 2020/1/16 10:21
 */
public class prob_57 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        // 特殊条件判断
        if (pHead == null || pHead.next == null) return pHead;
        // 创建新头节点
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode p1 = head, p2 = head.next;
        // p2进行持续搜索
        while (p2 != null) {
            if (p2.next != null && p2.val == p2.next.val) {
                // 找到最后的一个相同节点
                while (p2.next != null && p2.val == p2.next.val) {
                    p2 = p2.next;
                }
                p1.next = p2.next;
                p2 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return head.next;
    }
}
