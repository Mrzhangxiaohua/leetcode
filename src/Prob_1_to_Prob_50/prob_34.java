package Prob_1_to_Prob_50;

/**
 * @Description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * @Author: zf
 * @Date: 2019/10/13 21:55
 */
public class prob_34 {
    public static int[] searchRange(int[] nums, int target) {
        int tail = nums.length - 1;
        int head = 0;
        int[] result = new int[]{-1,-1};
        if (nums.length == 1 && nums[0] == target){
            return new int[]{0, 0};
        }
        while (head <= tail){
            if (nums[head] != target){
                head ++;
            }else {
                result[0] = head;
            }
            if (nums[tail] != target){
                tail --;
            }else {
                result[1] = tail;
            }
            if (result[0]!=-1 && result[1]!=-1){
                return result;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,1};
        int target = 6;
        int[] temp = searchRange(nums, target);
        System.out.println(temp);
    }
}
