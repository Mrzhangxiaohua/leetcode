package Prob_1_to_Prob_50;

/**
 * @Description:判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @Author: zf
 * @Date: 2019/6/10 21:57
 */
public class prob_9 {
    public static boolean isPalindrome(int x) {
        int xx = x;
        int sum = 0;
        int rest = 0;
        // 负数一定不是回文，因为有负号
        if (x < 0) return false;
        //单一的数字0是回文串
        if (x == 0) return true;
        //利用求余恢复方法，将数据恢复原始状态
        while (x != 0){
            rest = x % 10;
            x = (x - rest) / 10;
            sum = sum * 10 + rest;
        }
        //最终进行判断
        if (sum == xx) return true;
        else return false;
    }

    public static void main(String[] args) {
        boolean c = isPalindrome(1001);
        System.out.println(c);
    }
}
