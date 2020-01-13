package jianzhi_offer;

/**
 * @Description: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @Author: zf
 * @Date: 2020/1/13 21:50
 */
public class prob_48 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean isEnd = (sum != 0) && (sum += Sum_Solution(n-1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        prob_48 solution = new prob_48();
        System.out.println(solution.Sum_Solution(3));
    }
}
