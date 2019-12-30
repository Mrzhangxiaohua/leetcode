package Prob_1_to_Prob_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Description:给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * @Author: zf
 * @Date: 2019/7/1 20:35
 */
public class prob_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        // HashSet去重
        HashSet<List<Integer>> map = new HashSet<>(lists);
        int len = nums.length;
        // 数组进行排序
        Arrays.sort(nums);
        // 进行遍历，最外层
        for (int i = 0; i < len - 3; i++) {
            // 倒数第二个
            for (int j = i + 1; j < len - 2; j++) {
                // 定义左右指针
                int left = j + 1;
                int right = len - 1;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);list.add(nums[j]);list.add(nums[left]);list.add(nums[right]);
                        map.add(list);
                        left++;
                        right--;
                        continue;
                    }else if (sum > target){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        lists.addAll(map);
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        fourSum(nums, target);
    }
}
