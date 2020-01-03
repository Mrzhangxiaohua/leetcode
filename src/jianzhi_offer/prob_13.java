package jianzhi_offer;

/**
 * @Description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * @Author: zf
 * @Date: 2020/1/3 20:58
 */
public class prob_13 {
    public double Power(double base, int exponent) {
        if (base == 0 && exponent == 0) return 1;
        if (base == 0) return 0;
        double multiple = 1;
        int flag = exponent > 0 ? 1 : -1;
        exponent = Math.abs(exponent);
        while (exponent > 0){
            multiple = multiple * base;
            exponent--;
        }
        return flag == 1 ? multiple : 1 / multiple;
    }

    public static void main(String[] args) {
        double base = 2.0;
        int exponent = -3;
        prob_13 solution = new prob_13();
        System.out.println(solution.Power(base, exponent));
    }
}
