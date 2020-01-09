package jianzhi_offer;

/**
 * @Description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @Author: zf
 * @Date: 2020/1/9 14:29
 */
public class prob_27 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        // 特殊判断
        if (pRootOfTree == null) return null;
        // 进行递归
        if (pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;

        TreeNode left = Convert(pRootOfTree.left);
        TreeNode node = left;
        if (node == null)
            pRootOfTree.left = null;
        else {
            while (node.right != null)
                node = node.right;
            pRootOfTree.left = node;
            node.right = pRootOfTree;
        }
        TreeNode right = Convert(pRootOfTree.right);
        pRootOfTree.right = right;
        if (right != null)
            right.left = pRootOfTree;
        return left != null ? left: pRootOfTree;
    }
}
