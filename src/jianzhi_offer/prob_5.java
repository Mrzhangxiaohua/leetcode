package jianzhi_offer;

import java.util.Stack;

/**
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @Author: zf
 * @Date: 2020/1/2 19:49
 */
public class prob_5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception{
        if (stack1.isEmpty() && stack2.isEmpty())
            throw new Exception("Query Empty");
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        return stack2.pop();
    }
}
