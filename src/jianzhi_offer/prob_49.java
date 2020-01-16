package jianzhi_offer;

/**
 * @Description: 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @Author: zf
 * @Date: 2020/1/14 16:29
 */
public class prob_49 {
    public int Add(int num1, int num2) {
        int n1, n2;
        n1 = num1 & num2;
        n1 = n1 << 1;
        n2 = num1 ^ num2;
        System.out.println(n1 & n2);
        if ((n1 & n2) != 0) return Add(n1, n2);
        return n1 | n2;
    }

    public static void main(String[] args) {
        int num1 = 3, num2 = 15;
        prob_49 solution = new prob_49();
        System.out.println(solution.Add(num1, num2));
    }
}
