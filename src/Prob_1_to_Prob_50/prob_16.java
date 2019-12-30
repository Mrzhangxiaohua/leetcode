package Prob_1_to_Prob_50;

import java.util.Arrays;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/6/19 20:47
 */
public class prob_16 {
    public static int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int max = Integer.MAX_VALUE;
        int x = 0;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
//                    System.out.println(nums[i] + "---" + nums[j] + "---" + nums[k]);
                    int sum = nums[i] + nums[j] + nums[k];
                    int delt = Math.abs(target - sum);
                    if (max > delt) {
                        max = delt;
                        x = sum;
                    }
                }
            }
        }
        System.out.println(x);
        return x;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,2,1,-4};
        int[] nums = {-16,-2,17,-16,3,-7,-13,20,-4,12,5,13,-7,0,5,4,-17,-16,9,1,8,-6,0,-8,16,10,-6,9,-4,12,16,5,19,2,-9,-17,-8,-17,7,-10,2,20,-18,-20,-14,-6,6,17,-10,-8,18,-15,7,-9,13,13,-13,3,18,10,12,16,-6,-19,-6,-13,8,-5,16,5,8,-3,-9,-9,-5,14,14,-13,-18,13,15,-3,9,14,18,-14,-14,1,20,-4,-6,0,3,15,20,20,9,13,-8,-1,-2,6,-58};
        threeSumClosest(nums, -58);
    }
}
