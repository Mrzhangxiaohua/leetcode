package jianzhi_offer;

/**
 * @Description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @Author: zf
 * @Date: 2020/1/3 10:06
 */
public class prob_11 {
    public int RectCover(int target) {
        if (target < 1) return 0;
        if (target == 1) return 1;
        int[] DP = {1,2};
        int sum;
        while (target > 2){
            sum = DP[0] + DP[1];
            DP[0] = DP[1];
            DP[1] = sum;
            target--;
        }
        return DP[1];
    }

    public static void main(String[] args) {
        prob_11 solution = new prob_11();
        System.out.println(solution.RectCover(5));
    }
}
