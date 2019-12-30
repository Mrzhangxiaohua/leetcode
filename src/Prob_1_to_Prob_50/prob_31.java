package Prob_1_to_Prob_50;

/**
 * @Description: 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 也就是说，你把数组连成一个数，得到的结果应该是跟这个数最近且比他大的数，如果这个数已经最大，就返回组合的最小数
 * @Author: zf
 * @Date: 2019/8/31 20:33
 */
public class prob_31 {
    public static void nextPermutation(int[] nums) {
        int len = nums.length - 2;
        while (len >= 0 && nums[len + 1] <= nums[len]) {
            len--;
        }
        if (len >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[len]) {
                j--;
            }
            System.out.println(j);
            // 进行两个数的交换
            swap(nums, len, j);
            // 后半部分进行交换
        }
        int start = len + 1;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start ++;
            end --;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{3,2,1});
    }
}
