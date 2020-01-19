package jianzhi_offer;

import java.util.ArrayList;

/**
 * @Description: 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * @Author: zf
 * @Date: 2020/1/19 14:07
 */
public class prob_66 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length < size || size < 1 || num.length < 1) return result;
        int[] subnum = new int[size];
        for (int i = 0; i <= num.length - size; i++) {
            for (int j = 0; j < size; j++) {
                subnum[j] = num[j + i];
            }
//            int x = maxValue(subnum);
            result.add(maxValue(subnum));
        }
        return result;
    }

    public int maxValue(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) max = nums[i];
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        prob_66 soltion = new prob_66();
        soltion.maxInWindows(num, size);
    }
}