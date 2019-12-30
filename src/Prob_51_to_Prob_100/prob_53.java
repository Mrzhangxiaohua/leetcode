package Prob_51_to_Prob_100;

import java.util.Arrays;

/**
 * @Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @Author: zf
 * @Date: 2019/12/11 8:46
 */
public class prob_53 {
    public int maxSubArray(int[] nums) {
        int num = 0;
        int temp = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(num < 0){
                num = 0;
            }
            num += nums[i];
            temp = Math.max(temp,num);
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        prob_53 solution = new prob_53();
        System.out.println(solution.maxSubArray(nums));
    }
}
