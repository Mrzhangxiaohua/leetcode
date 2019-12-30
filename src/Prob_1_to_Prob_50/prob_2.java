package Prob_1_to_Prob_50;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/5/28 14:59
 */
public class prob_2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode (int x){val = x;}
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q= l2,curr = dummyHead;
        int carry = 0;
        while (p !=null ||q != null){
            int x = (p!=null) ? p.val : 0;
            int y = (q!=null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum/10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p!=null) p=p.next;
            if (q!=null) q=q.next;
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int x[] = {2,4,3};
        int y[] = {5,6,4};
        ListNode l1 = new ListNode(0);
        ListNode p1 = l1;
        ListNode l2 = new ListNode(0);
        ListNode p2 = l2;
        for (int i = 0; i < 3; i++) {
            p1.next = new ListNode(x[i]);
            p1 = p1.next;
        }
        for (int i = 0; i < 3; i++) {
            p2.next = new ListNode(y[i]);
            p2 = p2.next;
        }
        ListNode l3 =  addTwoNumbers(l1,l2);
        ListNode p3  = l3.next;
        while (p3!=null){
            System.out.println(p3.val );
            p3 = p3.next;
        }
    }
}
