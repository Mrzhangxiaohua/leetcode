package jianzhi_offer;

/**
 * @Description: 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @Author: zf
 * @Date: 2020/1/13 9:44
 */
public class prob_40 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    // 方法1， 遍历再判断
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if ((left - right > 1) || (left - right) < -1)
            return false;
        else
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = TreeDepth(root.left) + 1;
        int right = TreeDepth(root.right) + 1;
        return left > right ? left : right;
    }

    // 方法2，后序遍历
    public boolean IsBalanced_Solution1(TreeNode root) {
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        int left = getDepth(root.left);
        // 指向空，则为-1
        if (left == -1)
            return -1;
        int right = getDepth(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
