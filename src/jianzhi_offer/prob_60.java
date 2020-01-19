package jianzhi_offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @Author: zf
 * @Date: 2020/1/18 9:53
 */
public class prob_60 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Special Judgement
        if (pRoot == null) return result;
        // Create Two Assist Stack
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> even = new Stack<>();
        // Define Layers
        int layer = 1;
        odd.push(pRoot);
        // Both Not Null
        while (!odd.isEmpty() || !even.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            // while odd layer
            if ((layer & 1) == 1) {
                while (!odd.isEmpty()) {
                    TreeNode node = odd.pop();
                    arrayList.add(node.val);
                    if (node.left != null) even.push(node.left);
                    if (node.right != null) even.push(node.right);
                }
            }
            else {
                while (!even.isEmpty()) {
                    TreeNode node = even.pop();
                    arrayList.add(node.val);
                    if (node.right != null) odd.push(node.right);
                    if (node.left != null) odd.push(node.left);
                }
            }
            result.add(arrayList);
            layer++;
        }
        return result;
    }
}
