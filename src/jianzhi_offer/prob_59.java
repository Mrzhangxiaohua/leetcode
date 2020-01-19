package jianzhi_offer;

/**
 * @Description: 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @Author: zf
 * @Date: 2020/1/16 11:38
 */
public class prob_59 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    public boolean isSymmetrical(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) return true;
        if (p1 == null || p2 == null) return false;
        if (p1.val != p2.val) return false;
        return isSymmetrical(p1.left, p2.right) && isSymmetrical(p1.right, p2.left);
    }
}
