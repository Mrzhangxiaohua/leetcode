package jianzhi_offer;

/**
 * @Description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @Author: zf
 * @Date: 2020/1/6 21:56
 */
public class prob_19 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public  TreeNode(int val) {
            this.val = val;
        }
    }
    public void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null) Mirror(root.left);
            if (root.right != null) Mirror(root.right);
        }
    }
}
