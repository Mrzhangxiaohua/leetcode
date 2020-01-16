package jianzhi_offer;

import java.util.HashSet;

/**
 * @Description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @Author: zf
 * @Date: 2020/1/16 9:36
 */
public class prob_56 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 借助set集合
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        HashSet<ListNode> hashSet = new HashSet<>();
        while (!hashSet.contains(pHead)) {
            if (pHead.next == null) return null;
            hashSet.add(pHead);
            pHead = pHead.next;

        }
        return pHead;
    }

    // 正常指针方法
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead == null) return null;
        ListNode p1 = pHead, p2 = pHead.next;
        // 判断长度
        while (p1 != p2 && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null) return null;
            p2 = p2.next;
        }
        if (p2 == null) return null;
        int count = 1;
        while (p1.next != p2) {
            p1 = p1.next;
            count++;
        }
        // 找到环的入口
        p1 = pHead;
        p2 = pHead;
        while (count-- > 0) {
            p2 = p2.next;
        }
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
