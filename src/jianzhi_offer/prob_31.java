package jianzhi_offer;

import java.util.Arrays;

/**
 * @Description: HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @Author: zf
 * @Date: 2020/1/9 17:19
 */
public class prob_31 {
    // 方法1，自己
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = 0;
        int len = 0;
        // 暴力从第一个位置遍历
        for (int i = 0; i < array.length; i++) {
            // 每一轮第一个若不为负
            if (array[i] > 0) {
                int temp = 0;
                for (int j = i; j < array.length; j++) {
                    temp = temp + array[j];
                    if (max < temp) {
                        len = j - i;
                    }
                    max = Math.max(max, temp);
                }
            }
        }
        if (max == 0){
            Arrays.sort(array);
            return array[array.length-1];
        }
        return max;
    }

    // 方法2，参考
    public int FindGreatestSumOfSubArray1(int[] array) {
        if (array == null || array.length == 0) return 0;
        int[] DP = new int[2];
        DP[0] = array[0];
        int max = DP[0];
        System.out.println(0&1);
        System.out.println(1&1);
        System.out.println(2&1);
        System.out.println(3&1);
        for (int i = 1; i < array.length; i++) {
            DP[i&1] = Math.max(array[i], array[i] + DP[(i-1) & 1]);
            max = Math.max(max, DP[i & 1]);
        }
        return 0;
    }
    public static void main(String[] args) {
        // 实例化
        prob_31 solution = new prob_31();
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(solution.FindGreatestSumOfSubArray1(array));
    }
}
