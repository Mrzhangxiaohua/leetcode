package Prob_1_to_Prob_50;

import java.util.*;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/10/28 10:22
 */
public class prob_40 {
    private List<List<Integer>> res = new ArrayList<>();
    private int len;
    private int[] candidates;

    public void findCombinationSum2(int[] candidates, int begin, int len, int residue, Stack<Integer> stack, List<List<Integer>> res){
        if (residue == 0){
            // 为什么要new 呢？
            res.add(new ArrayList<>(stack));
        }
        for (int i = begin; i < len && residue - candidates[i] >= 0; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]){
                continue;
            }
            stack.add(candidates[i]);
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.len = candidates.length;
        Arrays.sort(candidates);
        this.candidates = candidates;
        if (len == 0){
            return res;
        }
        findCombinationSum2(candidates, 0, len, target, new Stack<>(), res);
        return res;
    }
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        prob_40 solution = new prob_40();
        List<List<Integer>> combinationSum2 = solution.combinationSum2(candidates, target);
        System.out.println(combinationSum2);
    }
}
