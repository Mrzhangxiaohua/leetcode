package jianzhi_offer;

/**
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。(贪心跳)
 * @Author: zf
 * @Date: 2020/1/3 9:39
 */
public class prob_10 {
    // 1. 解法1
    public int JumpFloorII(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int before = 1;
        int after = 2;
        int sum = 0;
        while (target > 2){
            sum = 2 * after;
            after = sum;
            target -- ;
        }
        return sum;
    }
    // 2. 解法2
    public int JumpFloorII1(int target) {
        if (target < 1) return 0;
        int[] DP = {1, 2};
        if (target == 1) return DP[0];
        int temp;
        for (int i = 2; i < target; i++) {
            temp = 2 * DP[1];
            DP[1] = temp;
        }
        return DP[1];
    }

    public static void main(String[] args) {
        prob_10 solution = new prob_10();
        System.out.println(solution.JumpFloorII(4));
    }
}
