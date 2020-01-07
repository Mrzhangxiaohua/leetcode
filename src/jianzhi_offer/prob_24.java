package jianzhi_offer;

/**
 * @Description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * 分析：该数组最后一个必为根节点，且数组前半段小于根，后半段大于根。
 * @Author: zf
 * @Date: 2020/1/7 17:22
 */
public class prob_24 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        // 特殊判断
        if (sequence.length == 0) return false;
        int start = 0, end = sequence.length - 1;
        return judge(sequence, start, end);
    }

    public boolean judge(int[] sequence, int start, int end) {
        // 当指针重合
        if (start == end) return true;
        // 拿到数组最后一个值即为根节点
        int root = sequence[end];
        // 记录右子树的索引
        int index = end;
        // 找到root为分界线的段
        for (int i = start; i < end; i++) {
            if (sequence[i] > root) {
                index = i;
                break;
            }
        }
        // 判断右半段的合法性
        for (int i = index; i < end; i++) {
            if (sequence[i] < root) return false;
        }
        // 递归查看子树有没有问题
        if (index == end || index == start){
            return judge(sequence, start, end - 1);
        }
        else {
            return judge(sequence, start, index - 1) && judge(sequence, index, end -1);
        }


    }
}
