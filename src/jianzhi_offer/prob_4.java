package jianzhi_offer;

/**
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @Author: zf
 * @Date: 2020/1/2 8:51
 */
public class prob_4 {
    public class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) return null;
        return reConstructBinaryTreeCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    public TreeNode reConstructBinaryTreeCore(int[] pre, int preStartIdx, int preEndIdx, int[] in, int inStartIdx, int inEndIdx){
        TreeNode node = new TreeNode(pre[preStartIdx]);
        // 1. 递归到最后的条件?
        if (preStartIdx == preEndIdx){
            if (inStartIdx != inEndIdx || pre[preStartIdx] != in[inStartIdx])
                System.out.println();
        }
        int i = 0;
        // 2. 找到前序第一个节点在中序中的位置
        while (pre[preStartIdx] != in[inStartIdx + i])
            i++;
        // 3. 证明没有左子树
        if (i == 0)
            node.left = null;
        else
            node.left = reConstructBinaryTreeCore(pre, preStartIdx + 1, preStartIdx + i, in, inStartIdx, inStartIdx + i - 1);
        // 4. 证明没有右子树
        if (inStartIdx + i == inEndIdx)
            node.right = null;
        else
            node.right = reConstructBinaryTreeCore(pre, preStartIdx + i + 1, preEndIdx, in, inStartIdx + i + 1, inEndIdx);
        return node;
    }
}
