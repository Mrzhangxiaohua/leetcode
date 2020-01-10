package jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @Author: zf
 * @Date: 2020/1/9 16:46
 */
public class prob_29 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int len = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            // 优化后的写法，三元表达式可以对只有一个判断可以简写
            int val = map.containsKey(array[i]) ? map.get(array[i]):0;
            map.put(array[i], val + 1);
            // 判断是否大于一半
            if ((val + 1) > (len / 2)) return array[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        prob_29 solution = new prob_29();
        int[] array = {1};
        System.out.println(solution.MoreThanHalfNum_Solution(array));
    }
}
