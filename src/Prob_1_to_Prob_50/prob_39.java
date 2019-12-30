package Prob_1_to_Prob_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/10/27 10:22
 */
public class prob_39 {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;
    // 使用栈，递归的进行遍历
    private void findCombinationSum(int residuem, int start, Stack<Integer> pre){
        // 如果剩余的值等于0，则当前路径的值可以被记录下来
        // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
        if (residuem == 0){
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = start; i < len && residuem - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            findCombinationSum(residuem - candidates[i], i, pre);
            pre.pop();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        int len = candidates.length;
        if (len == 0){
            return res;
        }
        // 进行依次排序
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        prob_39 solution = new prob_39();
        List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
        System.out.println(combinationSum);
    }
}
