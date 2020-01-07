package jianzhi_offer;

import java.util.ArrayList;

/**
 * @Description: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * @Author: zf
 * @Date: 2020/1/7 18:47
 */
public class prob_25 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        // 空值判断
        if(root == null) return result;
        // 因为一定有根节点，因此更新目标，并记录根节点路径
        target -= root.val;
        path.add(root.val);
        // 搜索停止条件
        if (root.left == null && root.right == null && target == 0){
            result.add(new ArrayList<Integer>(path));
        }
        // 否则递归进行检索
        else {
            FindPath(root.left, target);
            FindPath(root.right, target);
        }
        // 这个条件很重要，每次回退时候删除路径中最后一个节点
        path.remove(path.size() - 1);
        return result;
    }
}
