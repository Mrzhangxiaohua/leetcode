package jianzhi_offer;

import java.util.Arrays;

/**
 * @Description: 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * @Author: zf
 * @Date: 2020/1/10 14:38
 */
public class prob_32 {
    // 方法1，暴力找到所有字符串，然后遍历
    public int NumberOf1Between1AndN_Solution(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        char[] chars = sb.toString().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            count = chars[i] == '1'? count+1 : count;
        }
        return count;
    }

    //方法2看不懂

    public static void main(String[] args) {
        prob_32 solution = new prob_32();
        solution.NumberOf1Between1AndN_Solution(1);
    }
}
