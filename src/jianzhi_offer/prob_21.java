package jianzhi_offer;

import java.util.Stack;

/**
 * @Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @Author: zf
 * @Date: 2020/1/7 15:43
 */
public class prob_21 {
    // 定义两个栈，普通栈和最小栈
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min;
    // 栈的push操作
    public void push(int node) {
        // stack中不断添加元素，同时在stack中找到最小元素，并放入到minStack中
        stack.push(node);
        // 如果最小栈也为空，则最小值为node
        if (minStack.isEmpty()) {
            min = node;
        }
        // 如果最小栈不为空，则取栈顶元素与新元素比较
        else {
            min = Math.min(node, minStack.peek());
        }
        minStack.push(min);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
