package Prob_1_to_Prob_50;

/**
 * @Description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @Author: zf
 * @Date: 2019/10/13 23:40
 */
public class prob_35 {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int height = nums.length - 1;
        int mid = (low + height) / 2;
        if (nums[low] >= target){
            return 0;
        }
        if (nums[height] < target){
            return height + 1;
        }
        while (low <= height){
            if (nums[mid] > target){
                height = mid - 1;
                mid = (low + height) / 2;
            }else if (nums[mid] < target){
                low = mid + 1;
                mid = (low + height) / 2;
            }else {
                return mid;
            }
        }
        return mid + 1;
    }
    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 2;
        int temp = searchInsert(nums, target);
        System.out.println(temp);
    }
}
