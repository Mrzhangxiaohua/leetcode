package jianzhi_offer;

/**
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @Author: zf
 * @Date: 2020/1/3 9:17
 */
public class prob_9 {
    // 1. 递归方法解答
    public int JumpFloor(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        while (target > 1){
            return JumpFloor(target-2) + JumpFloor(target - 1);
        }
        return 0;
    }
    // 2. 非递归方法解答
    public int JumpFloorNew(int target) {
        if (target < 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int before = 1;
        int after = 2;
        int sum = 0;
        while (target > 2){
            sum = before + after;
            before = after;
            after = sum;
            target--;
        }
        return sum;
    }

    public static void main(String[] args) {
        prob_9 solution = new prob_9();
        System.out.println(solution.JumpFloorNew(6));
    }
}
