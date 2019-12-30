package Prob_1_to_Prob_50;

/**
 * @Description: 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度
 * @Author: zf
 * @Date: 2019/8/28 11:03
 */
public class prob_27 {
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 1 && nums[0]!=val) return 1;
        if (nums.length == 1 && nums[0]!=val){
            nums = new int[]{};
            return 0;
        }
        // 1. 定义快指针
        int i = 0;
        // 2. 定义遍历指针
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val){
                continue;
            }else {
                nums[i] = nums[j];
                i++;
            }
        }
        // 3. 返回count
        return i;
    }

    public static void main(String[] args) {
        int[] m = {0,1,2,2,3,0,4,2};
//        int[] m = {3, 3};
        int val = 2;
        removeElement(m, val);
    }
}
