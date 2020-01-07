package jianzhi_offer;

import java.util.ArrayList;

/**
 * @Description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @Author: zf
 * @Date: 2020/1/7 16:22
 */
public class prob_23 {
    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> temp = new ArrayList<>();
        // 用于特殊判断
        if (root == null) return result;
        // 如果root不为空，则将节点放入到队列中
        temp.add(root);
        // 对节点依次入队，并依次弹出，在尾部再压入节点的左右子树
        while (temp.size() != 0) {
            // 队头的对象出队
            TreeNode node = temp.remove(0);
            // 层次遍历数组添加value
            result.add(node.val);
            // 压入左有子树
            if (node.left != null){
                temp.add(node.left);
            }

            if (node.left != null){
                temp.add(node.right);
            }
        }
        return result;
    }
}
