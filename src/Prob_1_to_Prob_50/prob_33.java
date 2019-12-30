package Prob_1_to_Prob_50;

/**
 * @Description: 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。你可以假设数组中不存在重复的元素。你的算法时间复杂度必须是 O(log n) 级别。
 * @Author: zf
 * @Date: 2019/10/11 23:57
 */
public class prob_33 {
    public static int search(int[] nums, int target) {
        int length = nums.length;
        // 定义头指针和尾指针
        int head = 0;
        int tail = length - 1;
        if (length == 0){
            return -1;
        }
        if (length == 1 && nums[0] == target){
            return 0;
        }
        if (length == 1 && nums[0] != target){
            return -1;
        }
        // 头指针和尾指针同时移动，直到找出目标，否则返回-1
        while (head <= tail){
            if (nums[head] != target){
                head++;
            }else {
                return head;
            }
            if (nums[tail] != target){
                tail --;
            }else {
                return tail;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        int target = 3;
        int temp = search(nums, target);
        System.out.println(temp);
    }
}
