package jianzhi_offer;

/**
 * @Description: 输入一个链表，反转链表后，输出新链表的表头。
 * @Author: zf
 * @Date: 2020/1/5 10:06
 */
public class prob_16 {
    public static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        // 1. 存放头节点
        ListNode result = new ListNode(0);
        while (head!=null){
            // 创建新的节点
            ListNode newNode = new ListNode(head.val);
            if (result.next == null){
                result.next = newNode;
            }else {
                newNode.next = result.next;
                result.next = newNode;
            }
            head = head.next;
        }
        head = result.next;
        return head;
    }

    public static void main(String[] args) {
        prob_16 solution = new prob_16();
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
        solution.ReverseList(head);
    }
}
