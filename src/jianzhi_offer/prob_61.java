package jianzhi_offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Description: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @Author: zf
 * @Date: 2020/1/18 10:18
 */
public class prob_61 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // special judgement
        if (pRoot == null) return result;
        // queue
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        // in queue
        queue.offer(pRoot);
        // nodes of peer layer count
        int elementsCount = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            elementsCount--;
            list.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (elementsCount == 0) {
                result.add(list);
                list = new ArrayList<>();
                elementsCount = queue.size();
            }
        }
        return result;
    }
}
