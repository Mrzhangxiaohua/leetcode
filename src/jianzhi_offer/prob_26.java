package jianzhi_offer;

/**
 * @Description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 参考问题：https://blog.csdn.net/pomay/article/details/72547804
 * @Author: zf
 * @Date: 2020/1/7 21:52
 */
public class prob_26 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        // 特殊判断
        if (pHead == null) return null;
        // 克隆每个节点和next,将新的点放在节点之后
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode cloneNode = new RandomListNode(node.label);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }
        // 克隆每个随机指针
        node = pHead;
        while (node != null) {
            RandomListNode cloneNode = node.next;
            if (node.random != null) {
                cloneNode.random = node.random.next;
            }
            node = cloneNode.next;
        }

        // 拆分
        node = pHead;
        RandomListNode cloneHead = pHead.next;
        while (node != null) {
            RandomListNode cloneNode = node.next;
            node.next = cloneNode.next;
            node = node.next;
            if (node!=null){
                cloneNode.next = node.next;
            }else {
                cloneNode.next = null;
            }
        }
        return cloneHead;
    }
}
