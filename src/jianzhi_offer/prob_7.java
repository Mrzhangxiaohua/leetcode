package jianzhi_offer;

/**
 * @Description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * @Author: zf
 * @Date: 2020/1/2 20:48
 */
public class prob_7 {
    public int Fibonacci(int n) {
        if (n < 1) return 0;
        int[] fibonacci = {1, 1};
        n = n - 2;
        int temp = 0;
        while (n>0){
            temp = fibonacci[0] + fibonacci[1];
            fibonacci[0] = fibonacci[1];
            fibonacci[1] = temp;
            n--;
        }
        return fibonacci[1];
    }

    public static void main(String[] args) {
        prob_7 solution = new prob_7();
        System.out.println(solution.Fibonacci(7));
    }
}
