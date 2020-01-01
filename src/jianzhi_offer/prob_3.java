package jianzhi_offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Author: zf
 * @Date: 2020/1/1 17:16
 */
public class prob_3 {
    public static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 1.创建两个数据结构，list用于存放结果，stack用于先进后出
        ArrayList<Integer> list = new ArrayList();
        Stack<Integer> stack = new Stack<>();
        // 2.当为空表的时候，返回空
        if (listNode == null) return list;
        // 3.不为空表的时候，一次压栈
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        // 4.出栈实现反向序
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        prob_3 solution = new prob_3();
        int[] data = {1,3,5,2};
        int i = 1;
        ListNode head = new ListNode(data[0]);
        ListNode l1 = head;
        while (i < data.length){
            ListNode listNode = new ListNode(data[i++]);
            l1.next = listNode;
            l1 = listNode;
        }
        solution.printListFromTailToHead(head);
    }
}
