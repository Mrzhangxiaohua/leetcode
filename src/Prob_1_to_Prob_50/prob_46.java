package Prob_1_to_Prob_50;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/10/31 8:36
 */
public class prob_46 {
    public void generatePermution(int[] nums, boolean[] visited, int curSize, int len, Stack<Integer> path, List<List<Integer>> res){
        if (curSize == len){
            // path装的什么东东
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]){
                path.push(nums[i]);
                visited[i] = true;
                generatePermution(nums, visited, curSize + 1, len, path, res);
                path.pop();
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //创建一个是否使用标志
        boolean[] used = new boolean[len];
        if (len == 0){
            return res;
        }
        generatePermution(nums, used, 0, len, new Stack<>(), res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        prob_46 solution = new prob_46();
        List<List<Integer>> permute = solution.permute(nums);
        for (int i = 0; i < permute.size(); i++) {
            System.out.println(permute.get(i));
        }
    }
}
