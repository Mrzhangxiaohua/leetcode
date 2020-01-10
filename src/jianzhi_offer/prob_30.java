package jianzhi_offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @Author: zf
 * @Date: 2020/1/9 17:02
 */
public class prob_30 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || input.length < k) return list;
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        prob_30 solution = new prob_30();
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 10;
        System.out.println(solution.GetLeastNumbers_Solution(input, k));
    }
}
