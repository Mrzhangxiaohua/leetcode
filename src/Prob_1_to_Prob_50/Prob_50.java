package Prob_1_to_Prob_50;

/**
 * @Description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数
 * @Author: zf
 * @Date: 2019/11/10 18:31
 */
public class Prob_50 {
    public double fastPow(double x, long n){
        if (n == 0){
            return 1.0;
        }
        double half = fastPow(x, n /2);
        if (n % 2 == 0){
            return half * half;
        }else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0){
            x = 1/x;
            N = -N;
        }
        return fastPow(x, N);
    }

    public static void main(String[] args) {
        Prob_50 solution = new Prob_50();
        double x = 2.00000;
        int n = 5;
        double value = solution.myPow(x, n);
        System.out.println(value);
    }
}
