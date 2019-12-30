package Prob_1_to_Prob_50;

/**
 * @Description: 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * @Author: zf
 * @Date: 2019/8/29 21:12
 */

public class prob_29 {
    public static int divide(int dividend, int divisor) {
        // 特殊情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        // 全都变成负数，因为负数比正数多一位
        int flag = 1;
        if (dividend > 0) {
            dividend = -dividend;
        }else {
            flag = -flag;
        }
        if (divisor > 0){
            divisor = -divisor;
        }else {
            flag = -flag;
        }
        // 接下来迭代减少，并记录最大除数
        int s = 0, tmp, k;
        while (dividend <= divisor){
            // 记录除数
            tmp = divisor;
            k = 1;
            while (dividend <= tmp + tmp && tmp + tmp <0){
                tmp += tmp;
                k += k;
            }
            s = s + k;
            dividend -= tmp;
        }
        return flag > 0 ? s : -s;
    }

    public static void main(String[] args) {
//        divide(-2147483648, 1);
        divide(-40, -3);
    }
}

