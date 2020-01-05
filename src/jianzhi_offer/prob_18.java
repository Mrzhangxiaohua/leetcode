package jianzhi_offer;

/**
 * @Description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @Author: zf
 * @Date: 2020/1/5 23:35
 */
public class prob_18 {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = isEqualTree(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean isEqualTree(TreeNode tree1,TreeNode tree2) {
        if (tree2 == null) return true;
        if (tree1 == null) return false;
        if (tree1.val == tree2.val) {
            return isEqualTree(tree1.left, tree2.left) && isEqualTree(tree1.right, tree2.right);
        }
        return false;
    }
}
